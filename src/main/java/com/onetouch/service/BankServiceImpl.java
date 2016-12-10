package com.onetouch.service;

import java.util.HashMap;
import java.util.Map;

public class BankServiceImpl implements IBankService {
	private static Map<String, String> clientAccounts = new HashMap<String, String>();
	private static Map<String, String> partyAccounts = new HashMap<String, String>();
	private static Map<String, String> partyAccountsBalance = new HashMap<String, String>();
	static {
		for (int i = 1; i < 11; i++) {
			clientAccounts.put("clientAccount" + i, i * 500 + "");
			partyAccounts.put("partyId" + i, "partyAccount" + i);
			partyAccountsBalance.put("partyAccount" + i, 1000 * i + "");
		}
	}

	@Override
	public String getAvailableBalanceForAccount(String registeredBankAccountNo) {
		return clientAccounts.get(registeredBankAccountNo);
	}

	@Override
	public void deductAmountfromAccount(String registeredBankAccountNo, String transferAmount) {
		int actualBalanceInt = Integer.parseInt(clientAccounts.get(registeredBankAccountNo));
		int transferAmountInt = Integer.parseInt(transferAmount);
		clientAccounts.put(registeredBankAccountNo, String.valueOf((actualBalanceInt - transferAmountInt)));
	}

	@Override
	public boolean creditAmountInPartysAccount(String transferAmount, String partyId) {
		int newAmount = Integer.parseInt(partyAccountsBalance.get(partyAccounts.get(partyId)))
				+ Integer.parseInt(transferAmount);
		partyAccountsBalance.put(partyAccounts.get(partyId), newAmount + "");
		return true;
	}

}
