package com.kimmy.MpesaStkHandler.service.eventHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimmy.MpesaStkHandler.model.MpesaTransactionDao;
import com.kimmy.MpesaStkHandler.service.event.MpesaTransactionEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MpesaTransactionEventHandler {

    @EventListener
    @Async
    public void eventHandler(Object event) throws JsonProcessingException {
//        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(event.getData()));
//        MpesaTransactionDao dataObject = event.getData();
//         dataObject.getData().get("request");
        System.out.println(event);
    }
}