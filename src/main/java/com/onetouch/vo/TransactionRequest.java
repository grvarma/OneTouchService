package com.onetouch.vo;

import java.util.Date;

public class TransactionRequest {
	
	private String transferAmount;
	private String biometric;
	private String partyId;
	private String timeStamp;

	public String getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getBiometric() {
		return biometric;
	}

	public void setBiometric(String biometric) {
		this.biometric = biometric;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = String.valueOf(new Date().getTime());
	}

}
