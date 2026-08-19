CREATE DATABASE IF NOT EXISTS database_feliz
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE database_feliz;

DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nasc VARCHAR(10) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
)