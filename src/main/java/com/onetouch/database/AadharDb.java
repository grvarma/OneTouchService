package com.onetouch.database;

import java.util.ArrayList;
import java.util.List;

import com.onetouch.vo.ClientDetails;

public class AadharDb {
	
	private static List<ClientDetails> getClienDataForBiometric() {
		List<ClientDetails> listOfClientDetails = new ArrayList<ClientDetails>();
		for (int i = 1; i < 11; i++) {
			ClientDetails clientDetailsObj = new ClientDetails();
			clientDetailsObj.setAadharNo("aadharNo" + i);
			clientDetailsObj.setBiometric("biometric" + i);
			clientDetailsObj.setRegisteredBankAccountNo("clientAccount" + i);
			clientDetailsObj.setRegisteredMobileNo("registeredMobileNo" + i);
			listOfClientDetails.add(clientDetailsObj);
		}

		return listOfClientDetails;
	}

	public static ClientDetails getClientData(String argBiometric) {

		for (ClientDetails clientDetails : getClienDataForBiometric()) {
			if (clientDetails.getBiometric().equals(argBiometric)) {
				return clientDetails;
			}
		}
		return null;
	}
}
