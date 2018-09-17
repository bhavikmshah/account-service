package com.ubank.vab.accountservice.controller;

import com.ubank.vab.accountservice.model.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bhavi on 9/17/2018.
 */
@RestController
public class AccountController {

    @RequestMapping(value="/accounts",method= RequestMethod.GET,produces = "application/json")
    public Account getAccounts(HttpServletRequest request , HttpServletResponse response){
        Account acct = new Account();
        acct.setAccountNumber("123456789");
        acct.setAccountType("SAVINGS");
        return acct;
    }
}
