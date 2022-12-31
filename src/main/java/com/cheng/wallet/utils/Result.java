/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.cheng.wallet.utils;


import lombok.Data;


@Data
public class Result {

	private Integer code;

	private Object data;

	private String msg;

	public Result() {
	}

	public Result(Integer code) {
		this.code = code;
	}
	public Result(HttpStatus code) {
		this.code = code.getCode();
	}

	public Result(HttpStatus code, Object data){
		this.code = code.getCode();
		this.data = data;
	}
	public Result(Integer code, Object data) {
		this.code = code;
		this.data = data;
	}

	public Result(Integer code, Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public static Result ok() {
		return new Result(HttpStatus.OK);
	}

	public static Result ok(Integer code) {
		return new Result(code);
	}

	public static Result ok(Object data){
		return new Result(HttpStatus.OK, data);
	}

	public static Result ok(Integer code, Object data) {
		return new Result(code, data);
	}

	public static Result ok(Integer code, Object data, String msg) {
		return new Result(code, data, msg);
	}

	public static Result error(){
		return new Result(HttpStatus.ERROR);
	}

	public static Result error(Integer code) {
		return new Result(code);
	}

	public static Result error(Integer code, String msg){
		return new Result(code, msg);
	}
	public static Result error(Object data){
		return new Result(HttpStatus.OK, data);
	}


}
