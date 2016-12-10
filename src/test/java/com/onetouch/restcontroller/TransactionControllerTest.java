package com.onetouch.restcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.onetouch.service.IOneTouchService;
import com.onetouch.vo.ClientDetails;
import com.onetouch.vo.TransactionRequest;
import com.onetouch.vo.TransactionResponse;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(TransactionController.class)
public class TransactionControllerTest {

	@Mock
	private TransactionRequest transactionRequest;

	@Mock
	private IOneTouchService oneTouchService;

	@Mock
	private ClientDetails clientDetails;

	@InjectMocks
	private TransactionController controller;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testDoTransaction_success() {

		when(oneTouchService.getClientDetails(transactionRequest)).thenReturn(clientDetails);
		when(transactionRequest.getTransferAmount()).thenReturn("100");
		when(clientDetails.getRegisteredBankAccountNo()).thenReturn("getRegisteredBankAccountNo4");
		when(oneTouchService.checkBalanceAndDeduct("100", "getRegisteredBankAccountNo4")).thenReturn(true);
		when(oneTouchService.creditAmountInPartysAccount("100", "partyId4"))
				.thenReturn(new TransactionResponse("Success"));
		
	}

	@Test
	public void testDoTransaction_clentDetails_null() {

		Mockito.when(oneTouchService.getClientDetails(transactionRequest)).thenReturn(null);
		TransactionResponse response = controller.doTransaction(transactionRequest);
		assertEquals("Failed", response.getMessage());
	}

	@Test
	public void testDoTransaction_checkBalanceAndDeduct_fails() {

		when(oneTouchService.getClientDetails(transactionRequest)).thenReturn(clientDetails);
		when(transactionRequest.getTransferAmount()).thenReturn("100");
		when(clientDetails.getRegisteredBankAccountNo()).thenReturn("getRegisteredBankAccountNo4");
		when(oneTouchService.checkBalanceAndDeduct("100", "getRegisteredBankAccountNo4")).thenReturn(false);

		TransactionResponse response = controller.doTransaction(transactionRequest);
		assertEquals("Failed", response.getMessage());
	}

}
