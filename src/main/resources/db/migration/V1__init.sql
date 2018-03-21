CREATE TABLE account (
	id BIGINT NOT NULL AUTO_INCREMENT,
	account_number bigint NOT NULL,
	balance Decimal(10,2) NOT NULL,
	PRIMARY KEY (id)
);

insert into account (account_number, balance) values (12345676, 90.20);