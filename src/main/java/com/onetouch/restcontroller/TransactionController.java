package com.onetouch.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onetouch.service.IOneTouchService;
import com.onetouch.vo.ClientDetails;
import com.onetouch.vo.TransactionRequest;
import com.onetouch.vo.TransactionResponse;

@RestController
public class TransactionController {
	@Autowired
	public IOneTouchService oneTouchService;

	@RequestMapping(value = "/transaction", method = RequestMethod.POST, headers = "Accept=application/json")
	public TransactionResponse doTransaction(@RequestBody TransactionRequest transactionRequest) {

		ClientDetails clientDetails = oneTouchService.getClientDetails(transactionRequest);
		if (clientDetails == null) {
			return new TransactionResponse("Failed");
		}

		if (oneTouchService.checkBalanceAndDeduct(transactionRequest.getTransferAmount(),
				clientDetails.getRegisteredBankAccountNo())) {
			return oneTouchService.creditAmountInPartysAccount(transactionRequest.getTransferAmount(),
					transactionRequest.getPartyId());
		}
		return new TransactionResponse("Failed");
	}
}
