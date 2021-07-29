CREATE DATABASE `bjjr`;

USE `bjjr` ;

CREATE TABLE IF NOT EXISTS `bjjr`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `dataNascimento` VARCHAR(10) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `rg` VARCHAR(9) NOT NULL,
  `reputacao` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `bjjr`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `dataNascimento` VARCHAR(10) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `usuario` VARCHAR(10) NOT NULL,
  `chave` INT NOT NULL,
  `nivelAcesso` varchar(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `bjjr`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numeroPeca` INT NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  `material` VARCHAR(30) NOT NULL,
  `modelo` VARCHAR(30) NOT NULL,
  `preco` DECIMAL NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `bjjr`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataVenda` datetime NOT NULL,
  `totalVenda`  DECIMAL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `bjjr`.`itemvenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idVenda` INT NOT NULL,
  `idproduto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `totalVenda` DECIMAL NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idVenda` (`idVenda` ASC) VISIBLE,
   INDEX `idProduto` (`idProduto` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `bjjr`.`aluguel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(7) NOT NULL,
  `dataDevolucao` VARCHAR(7) NOT NULL,
  `idFuncionario` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `valor` DECIMAL NULL DEFAULT NULL,
  `metodo_pagamento` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFuncionario` (`idFuncionario` ASC) VISIBLE,
  INDEX `idCliente` (`idCliente` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = latin1;

