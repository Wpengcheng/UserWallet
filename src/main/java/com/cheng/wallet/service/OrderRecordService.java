package com.cheng.wallet.service;

import com.cheng.wallet.utils.Result;
import com.cheng.wallet.dto.OrderRecordDto;
import com.cheng.wallet.param.ConsumeParam;
import java.util.List;


public interface OrderRecordService {

    Result consume(ConsumeParam consumeParam);

    Result refund(ConsumeParam consumeParam);

    List<OrderRecordDto> listByUserId(Long userId);



}

