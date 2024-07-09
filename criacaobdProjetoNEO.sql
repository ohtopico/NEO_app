CREATE DATABASE ProjetoJulia;

use ProjetoJulia;
drop table objeto;
CREATE TABLE objeto (
	nome varchar(100),
    distancia float,
    velocidade float,
    tamanho float,
    risco varchar(20),
    dataaprox varchar(15),
    id int auto_increment primary key
);

select * from objeto;
SELECT dataaprox, COUNT(dataaprox) FROM objeto GROUP BY dataaprox ORDER BY dataaprox ASC;