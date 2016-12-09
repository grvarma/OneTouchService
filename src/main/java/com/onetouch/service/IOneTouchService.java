package com.onetouch.service;

import com.onetouch.vo.ClientDetails;
import com.onetouch.vo.TransactionRequest;
import com.onetouch.vo.TransactionResponse;

public interface IOneTouchService {

	public ClientDetails getClientDetails(TransactionRequest transactionRequest);

	public boolean checkBalanceAndDeduct(String transferAmount, String registeredBankAccountNo);

	public TransactionResponse creditAmountInPartysAccount(String transferAmount, String partyId);

}
