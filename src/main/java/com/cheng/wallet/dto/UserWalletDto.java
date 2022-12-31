package com.cheng.wallet.dto;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserWalletDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long userId;

	/**
	 * 余额
	 */
	private BigDecimal balance;

	private Date createTime;

	private Date updateTime;

	/**
	 * 1-未删除 2-已删除
	 */
	private Byte isDelete;


}
