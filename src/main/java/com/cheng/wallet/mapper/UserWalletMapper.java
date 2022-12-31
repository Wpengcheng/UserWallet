package com.cheng.wallet.mapper;

import com.cheng.wallet.dto.UserWalletDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface UserWalletMapper {


    //查询余额
    UserWalletDto query(@Param("userId") Long userId);


    //消费
    int consumeAmount(@Param("userId")Long userId, @Param("amount")BigDecimal amount);


    //退款
    int refundAmount(@Param("userId")Long userId,@Param("amount")BigDecimal amount);


}
