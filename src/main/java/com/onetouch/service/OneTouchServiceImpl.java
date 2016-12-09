package com.onetouch.service;

import org.springframework.stereotype.Service;

import com.onetouch.database.AadharDb;
import com.onetouch.vo.ClientDetails;
import com.onetouch.vo.TransactionRequest;
import com.onetouch.vo.TransactionResponse;

@Service
public class OneTouchServiceImpl implements IOneTouchService {
	IBankService bank = new BankServiceImpl();
	@Override
	public ClientDetails getClientDetails(TransactionRequest transactionRequest) {
		return AadharDb.getClientData(transactionRequest.getBiometric());
	}

	@Override
	public boolean checkBalanceAndDeduct(String transferAmount, String registeredBankAccountNo) {
		if (Integer.parseInt(transferAmount) <= Integer
				.parseInt(bank.getAvailableBalanceForAccount(registeredBankAccountNo))) {
			bank.deductAmountfromAccount(registeredBankAccountNo, transferAmount);
			return true;
		}
		return false;
	}

	@Override
	public TransactionResponse creditAmountInPartysAccount(String transferAmount, String partyId) {
		if (bank.creditAmountInPartysAccount(transferAmount, partyId)) {
			return new TransactionResponse("Success");
		}
		return new TransactionResponse("Failed");
	}

}
