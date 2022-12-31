package com.cheng.wallet.service;

import com.cheng.wallet.dto.UserWalletDto;


public interface UserWalletService  {


    //查询钱包
    UserWalletDto query(Long userId);

}

