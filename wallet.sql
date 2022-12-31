
create table user_wallet.wallet
(
	id bigint auto_increment
		primary key,
	user_id bigint not null comment '用户id
',
	balance decimal(10,2) null comment '余额',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	update_time datetime default CURRENT_TIMESTAMP not null comment '修改时间',
	is_delete tinyint default 1 not null comment '1未删除, 2已删除'
)
comment '钱包';





create table if not exists user_wallet.order_record
(
	id bigint auto_increment
		primary key,
	user_id bigint null comment '钱包id',
	order_id bigint null comment '订单id',
	amount decimal(7,2) null comment '金额',
	type tinyint null comment '0-支出 1-退款 2-提现',
	update_time datetime default CURRENT_TIMESTAMP not null comment '修改时间',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	is_delete tinyint default 1 not null comment '1:未删除,2:已删除'
)
charset=utf8mb4;

create index create_time
	on user_wallet.order_record (create_time);

