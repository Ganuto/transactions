package com.project.transactions.service;

import com.project.transactions.controller.data.request.AccountCreationRequest;
import com.project.transactions.controller.data.response.AccountCreationResponse;
import com.project.transactions.controller.data.response.AccountResponse;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    ResponseEntity<AccountCreationResponse> create(AccountCreationRequest accountCreationRequest);
    ResponseEntity<AccountResponse> get(Long accountId);
}