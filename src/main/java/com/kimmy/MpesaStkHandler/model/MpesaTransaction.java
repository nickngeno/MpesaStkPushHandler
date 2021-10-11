package com.kimmy.MpesaStkHandler.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MpesaTransaction {
    String mpesaReceiptNumber;
    Double amount;
    LocalDateTime transactionDate;
    String phoneNumber;

}
