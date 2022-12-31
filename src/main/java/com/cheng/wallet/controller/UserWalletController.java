package com.cheng.wallet.controller;

import java.math.BigDecimal;
import java.util.List;
import com.cheng.wallet.dto.OrderRecordDto;
import com.cheng.wallet.service.OrderRecordService;
import com.cheng.wallet.param.ConsumeParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cheng.wallet.dto.UserWalletDto;
import com.cheng.wallet.service.UserWalletService;
import com.cheng.wallet.utils.Result;

@RestController
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    @Autowired
    OrderRecordService orderRecordService;


    //查询用户钱包余额
    @RequestMapping(value ="userWallet/queryBalance/{userId}",method = RequestMethod.POST)
    public Result queryBalance(@PathVariable Long userId){
        UserWalletDto user = userWalletService.query(userId);
        BigDecimal balance = user.getBalance();
        return Result.ok(balance);
    }

    //消费
    @RequestMapping(value = "/userWallet/consume",method = RequestMethod.POST)
    public Result consume(@RequestBody ConsumeParam consumeParam){
        return orderRecordService.consume(consumeParam);
    }

    //退款
    @RequestMapping(value = "/userWallet/refund",method = RequestMethod.POST)
    public Result refund(@RequestBody ConsumeParam consumeParam){
        return orderRecordService.refund(consumeParam);
    }

    //明细
    @RequestMapping(value ="/userWallet/list/{userId}",method = RequestMethod.POST)
    public Result listByUserId(@PathVariable Long userId){
        List<OrderRecordDto> list = orderRecordService.listByUserId(userId);
        return Result.ok(list);
    }
}
