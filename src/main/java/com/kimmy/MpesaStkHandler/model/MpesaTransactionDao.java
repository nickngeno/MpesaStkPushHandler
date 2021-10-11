package com.kimmy.MpesaStkHandler.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class MpesaTransactionDao {
    Map<String, String> data;
}
