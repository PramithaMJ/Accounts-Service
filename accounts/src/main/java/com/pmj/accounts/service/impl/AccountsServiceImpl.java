package com.pmj.accounts.service.impl;

import com.pmj.accounts.constants.AccountsConstants;
import com.pmj.accounts.dto.AccountsDTO;
import com.pmj.accounts.dto.CustomerDTO;
import com.pmj.accounts.entity.Accounts;
import com.pmj.accounts.entity.Customer;
import com.pmj.accounts.exception.CustomerAlreadyExistsException;
import com.pmj.accounts.exception.ResourceNotFoundException;
import com.pmj.accounts.mapper.AccountsMapper;
import com.pmj.accounts.mapper.CustomerMapper;
import com.pmj.accounts.repository.AccountsRepository;
import com.pmj.accounts.repository.CustomerRepository;
import com.pmj.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

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
        Customer customer = CustomerMapper.mapToCustomer(customerDTO,new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findAllByMobileNumber(customerDTO.getMobileNumber());

        if (optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered with given mobile number"
            +customerDTO.getMobileNumber()
            );
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");

        return newAccount;
    }

    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findAllByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString())
        );
        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDto(customer,new CustomerDTO());
        customerDTO.setAccountsDTO(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));
        return customerDTO;
    }

}