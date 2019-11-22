CREATE TABLE endereco (
ID int NOT NULL AUTO_INCREMENT,
RUA varchar(50),
NUME int,
bairro varchar(30),
cidade varchar(30),
estado varchar(2),
PRIMARY KEY (id)
);

CREATE TABLE pessoa (
    ID int AUTO_INCREMENT NOT NULL ,
    NOME varchar(100) NOT NULL,
    CPF varchar(11) NOT NULL UNIQUE,
    EMAIL varchar(150) NOT NULL,
    ENDERECO varchar(100) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE doacao (
    ID int AUTO_INCREMENT NOT NULL,
    VALOR FLOAT NOT NULL,
    PESSOA int NOT NULL ,
    CPF varchar(11) NOT NULL ,
	DIA TIMESTAMP(6),
    PRIMARY KEY (ID),
    FOREIGN KEY (PESSOA) REFERENCES pessoa(ID)
);