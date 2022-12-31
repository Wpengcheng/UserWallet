package com.cheng.wallet.dto;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class OrderRecordDto implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final Byte STATUS_CONSUME = 0;
	public static final Byte STATUS_REFUND = 1;
	public static final Byte STATUS_WITHDRAW = 2;


	private Long id;

	private Long userId;

	/**
	 * 订单id
	 */
	private Long orderId;

	private BigDecimal amount;

	/**
	 * 0-支出 1-退款 2-提现
	 */
	private Byte type;

	private Date createTime;

	private Date updateTime;

	/**
	 * 1-未删除 2-已删除
	 */
	private Byte isDelete;
}
