package com.kimmy.MpesaStkHandler.service;

import com.kimmy.MpesaStkHandler.model.EventDao;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public void getMpesaTransaction(Object request) {
        Map<String, Object> mydata = new HashMap<>();
        mydata.put("myrequest", request);
//        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        mydata.put("amount", request.);
//        mydata.put("mpesaReceiptNumber", httpServletRequest.getHeader("user-agent"));
//        mydata.put("transactionDate", httpServletRequest.getHeader("user-agent"));
//        mydata.put("phoneNumber", httpServletRequest.getHeader("user-agent"));
        eventPublisher.publishEvent(new MpesaTransactionEvent<>(MpesaTransactionDao.builder().data(mydata).build()));
    }
}
