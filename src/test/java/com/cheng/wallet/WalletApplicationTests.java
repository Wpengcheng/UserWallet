package com.cheng.wallet;

import com.cheng.wallet.mapper.OrderRecordMapper;
import com.cheng.wallet.service.OrderRecordService;
import com.cheng.wallet.service.UserWalletService;
import com.cheng.wallet.param.ConsumeParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WalletApplicationTests {

    @Autowired
    private UserWalletService userWalletService;

    @Autowired
    private OrderRecordService orderRecordService;


    @Test
    void contextLoads() {
        ConsumeParam consumeParam = new ConsumeParam();
        consumeParam.setAmount(BigDecimal.valueOf(20));
        consumeParam.setUserId(123456789l);
        consumeParam.setOrderId(1230123l);
        System.out.println(userWalletService.query(123456789l).getBalance());
        System.out.println(orderRecordService.consume(consumeParam));
        System.out.println(orderRecordService.refund(consumeParam));
        System.out.println(orderRecordService.listByUserId(123456789l));
    }
}
