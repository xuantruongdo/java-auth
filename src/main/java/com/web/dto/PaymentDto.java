package com.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private Long amount;
    private String content;
    private String returnUrl;
    private String notifyUrl;
}

