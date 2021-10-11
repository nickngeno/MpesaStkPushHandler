package com.kimmy.MpesaStkHandler.service.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class TransactionEvent<T> extends ApplicationEvent  {

    private final T data;

    public TransactionEvent(T source) {
        super(source);
        this.data = source;
    }

}
