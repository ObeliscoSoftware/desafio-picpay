create table usuario (
	id bigserial not null, 
	cpf varchar(255) UNIQUE, 
	email varchar(255) UNIQUE, 
	nome varchar(255), 
	saldo numeric(38,2), 
	senha varchar(255), 
	tipo_usuario varchar(255) check (tipo_usuario in ('COMUM','LOJISTA')), 
primary key (id)
);