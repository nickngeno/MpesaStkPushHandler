package com.kimmy.MpesaStkHandler.controller;

import com.kimmy.MpesaStkHandler.model.MpesaTransaction;
import com.kimmy.MpesaStkHandler.model.MpesaTransactionDao;
import com.kimmy.MpesaStkHandler.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1")
public class MpesaNotificationController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("")
    public String getTransactionNotification(@RequestBody String message) {
        transactionService.getTransaction(message);
        return "notification received!";
    }

    @PostMapping("/mpesa")
    public String getMpesaTransaction(@RequestBody Object request) {
        System.out.println("hit here");
        transactionService.getMpesaTransaction(request);
        return "Transaction successfully received!";
    }
}
