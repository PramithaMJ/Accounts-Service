package com.pmj.accounts.service;

import com.pmj.accounts.dto.CustomerDTO;

public interface IAccountService {

    /**
     * Create account
     * @param  customerDTO - customerDTO Object
     */
    void createAccoun(CustomerDTO customerDTO);

    /**
     * Create account
     * @param  customerDTO - customerDTO Object
     * @return Account Details based on a given number
     */
    CustomerDTO fetchAccount(String mobileNumber);


    /**
     * Create account
     * @param  customerDTO - customerDTO Object
     * @return boolean indicating if the update a account details success or not
     */
    boolean updateAccount(CustomerDTO customerDTO);


}