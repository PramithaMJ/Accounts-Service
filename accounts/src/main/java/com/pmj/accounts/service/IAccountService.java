package com.pmj.accounts.service;

import com.pmj.accounts.dto.CustomerDTO;

public interface IAccountService {

    /**
     * Create account
     * @param  customerDTO - customerDTO Object
     */
    void createAccoun(CustomerDTO customerDTO);

    CustomerDTO fetchAccount(String mobileNumber);


}