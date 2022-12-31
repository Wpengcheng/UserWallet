package com.cheng.wallet.service.impl;

import com.cheng.wallet.mapper.UserWalletMapper;
import com.cheng.wallet.dto.UserWalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cheng.wallet.service.UserWalletService;


@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    private UserWalletMapper userWalletMapper;

    @Override
    public UserWalletDto query(Long userId) {
        return userWalletMapper.query(userId);
    }

}