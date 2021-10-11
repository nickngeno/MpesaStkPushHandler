package com.kimmy.MpesaStkHandler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FailedTransaction {
    String merchantRequestID;
    String checkoutRequestID;
    Integer resultCode ;
    String resultDesc;
}
