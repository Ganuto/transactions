package com.project.transactions.controller;

import com.project.transactions.controller.data.request.TransactionRequest;
import com.project.transactions.controller.data.response.TransactionResponse;
import com.project.transactions.domain.OperationType;
import com.project.transactions.mock.TransactionMock;
import com.project.transactions.service.TransactionService;
import com.project.transactions.util.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TransactionController.class)
public class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void createPurchaseTransactionSuccessfully() throws Exception {
        TransactionRequest transactionRequest = TransactionMock.createTransactionRequest(OperationType.PURCHASE, BigDecimal.valueOf(-12.23));
        TransactionResponse transactionResponse = TransactionMock.createTransactionResponse(OperationType.PURCHASE, BigDecimal.valueOf(-12.23));

        when(transactionService.execute(any(TransactionRequest.class))).thenReturn(transactionResponse);

        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.convertObjectToJsonString(transactionRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transaction_id").value(transactionResponse.getTransactionId()))
                .andExpect(jsonPath("$.account_id").value(transactionResponse.getAccountId()))
                .andExpect(jsonPath("$.operation_type_id").value(transactionResponse.getOperationTypeId()))
                .andExpect(jsonPath("$.amount").value(transactionResponse.getAmount()));
    }

    @Test
    public void createInstallmentPurchaseTransactionSuccessfully() throws Exception {
        TransactionRequest transactionRequest = TransactionMock.createTransactionRequest(OperationType.INSTALLMENT_PURCHASE, BigDecimal.valueOf(-12.23));
        TransactionResponse transactionResponse = TransactionMock.createTransactionResponse(OperationType.INSTALLMENT_PURCHASE, BigDecimal.valueOf(-12.23));

        when(transactionService.execute(any(TransactionRequest.class))).thenReturn(transactionResponse);

        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.convertObjectToJsonString(transactionRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transaction_id").value(transactionResponse.getTransactionId()))
                .andExpect(jsonPath("$.account_id").value(transactionResponse.getAccountId()))
                .andExpect(jsonPath("$.operation_type_id").value(transactionResponse.getOperationTypeId()))
                .andExpect(jsonPath("$.amount").value(transactionResponse.getAmount()));
    }

    @Test
    public void createWithdrawTransactionSuccessfully() throws Exception {
        TransactionRequest transactionRequest = TransactionMock.createTransactionRequest(OperationType.WITHDRAWAL, BigDecimal.valueOf(-12.23));
        TransactionResponse transactionResponse = TransactionMock.createTransactionResponse(OperationType.WITHDRAWAL, BigDecimal.valueOf(-12.23));

        when(transactionService.execute(any(TransactionRequest.class))).thenReturn(transactionResponse);

        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.convertObjectToJsonString(transactionRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transaction_id").value(transactionResponse.getTransactionId()))
                .andExpect(jsonPath("$.account_id").value(transactionResponse.getAccountId()))
                .andExpect(jsonPath("$.operation_type_id").value(transactionResponse.getOperationTypeId()))
                .andExpect(jsonPath("$.amount").value(transactionResponse.getAmount()));
    }

    @Test
    public void createPaymentTransactionSuccessfully() throws Exception {
        TransactionRequest transactionRequest = TransactionMock.createTransactionRequest(OperationType.PAYMENT, BigDecimal.valueOf(10.23));
        TransactionResponse transactionResponse = TransactionMock.createTransactionResponse(OperationType.PAYMENT, BigDecimal.valueOf(10.23));

        when(transactionService.execute(any(TransactionRequest.class))).thenReturn(transactionResponse);

        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.convertObjectToJsonString(transactionRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transaction_id").value(transactionResponse.getTransactionId()))
                .andExpect(jsonPath("$.account_id").value(transactionResponse.getAccountId()))
                .andExpect(jsonPath("$.operation_type_id").value(transactionResponse.getOperationTypeId()))
                .andExpect(jsonPath("$.amount").value(transactionResponse.getAmount()));
    }
}