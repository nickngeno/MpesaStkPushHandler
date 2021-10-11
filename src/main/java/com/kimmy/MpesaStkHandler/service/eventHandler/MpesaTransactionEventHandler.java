package com.kimmy.MpesaStkHandler.service.eventHandler;

import com.kimmy.MpesaStkHandler.service.event.MpesaTransactionEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MpesaTransactionEventHandler {

    @EventListener
    @Async
    public void eventHandler(MpesaTransactionEvent event) {
        System.out.println(event);
    }
}
