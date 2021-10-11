package com.kimmy.MpesaStkHandler.service;

import com.kimmy.MpesaStkHandler.model.EventDao;
import com.kimmy.MpesaStkHandler.model.FailedTransaction;
import com.kimmy.MpesaStkHandler.model.MpesaTransaction;
import com.kimmy.MpesaStkHandler.model.MpesaTransactionDao;
import com.kimmy.MpesaStkHandler.service.event.MpesaTransactionEvent;
import com.kimmy.MpesaStkHandler.service.event.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class TransactionService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void getTransaction(String message) {
        Map<String, String> data = new HashMap<>();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        data.put("host", request.getHeader("host"));
        data.put("user-agent", request.getHeader("user-agent"));
        data.put("messsage", message);
        eventPublisher.publishEvent(new TransactionEvent<>(EventDao.builder().data(data).build()));
    }

    public void getMpesaTransaction(Object request) throws IOException {
//        Map<String , String> myData = new HashMap<>();
//        myData.put("merchantRequestID", request.getMerchantRequestID());
//        myData.put("checkoutRequestID", request.getCheckoutRequestID());
//        myData.put("resultCode", request.getResultCode().toString());
//        myData.put("resultDesc", request.getResultDesc());
//        eventPublisher.publishEvent(new MpesaTransactionEvent<>(MpesaTransactionDao.builder().data(myData).build()));
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        FailedTransaction transaction = new FailedTransaction();
        eventPublisher.publishEvent(new MpesaTransactionEvent<>(request));
    }
}
