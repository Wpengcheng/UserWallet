package com.cheng.wallet.param;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConsumeParam {

    private Long userId;

    private Long orderId;//订单

    private BigDecimal amount;//金额
}
