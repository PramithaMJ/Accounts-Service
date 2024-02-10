package com.pmj.accounts.service.impl;

import com.pmj.accounts.dto.CustomerDTO;
import com.pmj.accounts.repository.AccountsRepository;
import com.pmj.accounts.repository.CustomerRepository;
import com.pmj.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * Create account
     * @param customerDTO - customerDTO Object
     */
    @Override
    public void createAccoun(CustomerDTO customerDTO) {

    }
}
