package com.onetouch.service;

public interface IBankService {

	public String getAvailableBalanceForAccount(String registeredBankAccountNo);

	public void deductAmountfromAccount(String registeredBankAccountNo, String transferAmount);
	
	public boolean creditAmountInPartysAccount(String transferAmount, String partyId);

}
