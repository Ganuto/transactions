package com.project.transactions.service;

import com.project.transactions.controller.data.request.TransactionRequest;
import com.project.transactions.controller.data.response.TransactionResponse;
import com.project.transactions.domain.OperationType;
import com.project.transactions.domain.Transaction;
import com.project.transactions.mock.TransactionMock;
import com.project.transactions.repository.TransactionRepository;
import com.project.transactions.service.impl.TransactionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TransactionServiceTest {

    @MockBean
    private AccountService accountService;

    @MockBean
    private TransactionRepository transactionRepository;

    @SpyBean
    private TransactionServiceImpl transactionService;

    @Test
    public void createTransactionSuccessfully() {
        TransactionRequest transactionRequest = TransactionMock.createTransactionRequest(OperationType.PAYMENT, BigDecimal.valueOf(10.23));
        Transaction transaction = TransactionMock.createTransaction(OperationType.PAYMENT, BigDecimal.valueOf(10.23));

        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);

        TransactionResponse transactionResponse = transactionService.execute(transactionRequest);

        assertEquals(transaction.getId(), transactionResponse.getTransactionId());
        assertEquals(transaction.getAccountId(), transactionResponse.getAccountId());
        assertEquals(transaction.getOperationType().getId(), transactionResponse.getOperationTypeId());
        assertEquals(transaction.getAmount(), transactionResponse.getAmount());
    }
}
