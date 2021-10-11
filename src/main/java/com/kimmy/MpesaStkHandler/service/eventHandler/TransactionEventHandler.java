package com.kimmy.MpesaStkHandler.service.eventHandler;

import com.kimmy.MpesaStkHandler.model.EventDao;
import com.kimmy.MpesaStkHandler.service.event.TransactionEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventHandler {

    @EventListener
    @Async
    public void eventHandler(TransactionEvent<EventDao> event) {
        System.out.println(event);
    }
}
