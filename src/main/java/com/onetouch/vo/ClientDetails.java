package com.onetouch.vo;

public class ClientDetails {
	private String aadharNo;
	private String registeredBankAccountNo;
	private String registeredMobileNo;
	private String biometric;

	public String getBiometric() {
		return biometric;
	}

	public void setBiometric(String biometric) {
		this.biometric = biometric;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getRegisteredBankAccountNo() {
		return registeredBankAccountNo;
	}

	public void setRegisteredBankAccountNo(String registeredBankAccountNo) {
		this.registeredBankAccountNo = registeredBankAccountNo;
	}

	public String getRegisteredMobileNo() {
		return registeredMobileNo;
	}

	public void setRegisteredMobileNo(String registeredMobileNo) {
		this.registeredMobileNo = registeredMobileNo;
	}

}
