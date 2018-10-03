package com.ubank.vab.accountservice.controller;

import com.ubank.vab.accountservice.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by bhavi on 9/17/2018.
 */
@RestController
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR" };

    @RequestMapping(value="/accounts",method= RequestMethod.POST,produces = "application/json")
    public Account getAccounts(HttpServletRequest request , HttpServletResponse response, @RequestBody Account account){
        for (String header : IP_HEADER_CANDIDATES) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                System.out.println(" header " + header + " "+ ip);
            }
        }

        System.out.println("request.getRemoteHost()"+request.getRemoteHost());
        System.out.println("request.getRemoteAddr()"+request.getRemoteAddr());
        System.out.println("request.getLocalAddr()"+request.getLocalAddr());
        System.out.println("request.getLocalName()"+request.getLocalName());
        Enumeration e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String header = (String)e.nextElement();
            System.out.println(" header name " + header + " value "+ request.getHeader(header));
        }

        if (request != null) {
           String remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
            System.out.println("remoteAddr "+ remoteAddr);
        }

        logger.debug(account.getAccountNumber());
        Account acct = new Account();
        acct.setAccountNumber("123456789");
        acct.setAccountType("SAVINGS");
        logger.debug("In get Accounts");
        System.out.println(StaticLoggerBinder.getSingleton().getLoggerFactory());
        return acct;
    }
}
