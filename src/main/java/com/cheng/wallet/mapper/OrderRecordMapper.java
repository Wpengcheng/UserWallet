package com.cheng.wallet.mapper;


import com.cheng.wallet.dto.OrderRecordDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderRecordMapper {

    int insert(OrderRecordDto orderRecordDto);

    List<OrderRecordDto> listByUserId(@Param("userId")Long userId);
}
