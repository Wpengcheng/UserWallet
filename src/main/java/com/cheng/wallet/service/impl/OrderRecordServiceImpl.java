package com.cheng.wallet.service.impl;

import com.cheng.wallet.utils.Result;
import com.cheng.wallet.mapper.UserWalletMapper;
import com.cheng.wallet.dto.OrderRecordDto;
import com.cheng.wallet.param.ConsumeParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import com.cheng.wallet.mapper.OrderRecordMapper;
import com.cheng.wallet.service.OrderRecordService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderRecordServiceImpl implements OrderRecordService {


    @Autowired
    OrderRecordMapper orderRecordMapper;

    @Autowired
    UserWalletMapper userWalletMapper;

    @Override
    @Transactional
    public Result consume(ConsumeParam consumeParam) {
        //查找当前用户的余额
        if (consumeParam.getUserId()==null){
            return Result.error("用户不存在");
        }
        BigDecimal balance1 = userWalletMapper.query(consumeParam.getUserId()).getBalance();
        //减去消费金额
        BigDecimal balance = balance1.subtract(consumeParam.getAmount());
        //如果钱包余额小于消费金额
        if(balance.compareTo(BigDecimal.ZERO) < 0){
            return Result.error("余额不足");
        }else {
            //生成消费记录
            OrderRecordDto orderRecordDto = new OrderRecordDto();
            orderRecordDto.setOrderId(consumeParam.getOrderId());
            orderRecordDto.setAmount(consumeParam.getAmount());
            orderRecordDto.setType(OrderRecordDto.STATUS_CONSUME);
            orderRecordDto.setUserId(consumeParam.getUserId());
            orderRecordMapper.insert(orderRecordDto);
            //修改钱包数据
            return Result.ok(userWalletMapper.consumeAmount(consumeParam.getUserId(), consumeParam.getAmount()));
        }
    }

    @Override
    @Transactional
    public Result refund(ConsumeParam consumeParam) {
        OrderRecordDto orderRecordDto = new OrderRecordDto();
        orderRecordDto.setOrderId(consumeParam.getOrderId());
        orderRecordDto.setAmount(consumeParam.getAmount());
        orderRecordDto.setType(OrderRecordDto.STATUS_REFUND);
        orderRecordDto.setUserId(consumeParam.getUserId());
        orderRecordMapper.insert(orderRecordDto);
        return Result.ok(userWalletMapper.refundAmount(consumeParam.getUserId(), consumeParam.getAmount()));
    }

    //查看钱包订单记录
    @Override
    public List<OrderRecordDto> listByUserId(Long userId) {
        List<OrderRecordDto> list = orderRecordMapper.listByUserId(userId);
        return list;
    }






}