drop table if exists tb_festa;

create table tb_festa(

	id				SERIAL		PRIMARY key	,
	solicitante		VARCHAR					,
	dia				NUMERIC					,
	mes				NUMERIC					,
	convidados		VARCHAR			

);

select * from tb_festa;