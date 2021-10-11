package com.kimmy.MpesaStkHandler.service.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MpesaTransactionEvent<T> extends ApplicationEvent {

    public MpesaTransactionEvent(T source) {
        super(source);
    }
}
