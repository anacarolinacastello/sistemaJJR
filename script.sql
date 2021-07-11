CREATE DATABASE `jjr`;
USE `jjr` ;

CREATE TABLE IF NOT EXISTS `jjr`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `dataNascimento` VARCHAR(10) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(9) NOT NULL,
  `reputacao` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `jjr`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `dataNascimento` VARCHAR(10) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `usuario` VARCHAR(10) NOT NULL,
  `chave` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `jjr`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numeroPeca` INT NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  `material` VARCHAR(30) NOT NULL,
  `modelo` VARCHAR(30) NOT NULL,
  `preco` FLOAT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `jjr`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `idFuncionario` INT NOT NULL,
  `idCliente` INT NULL DEFAULT NULL,
  `idProduto` INT NOT NULL,
  `valor` FLOAT NULL DEFAULT NULL,
  `metodo_pagamento` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFuncionario` (`idFuncionario` ASC) VISIBLE,
  INDEX `idCliente` (`idCliente` ASC) VISIBLE,
  INDEX `idProduto` (`idProduto` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `jjr`.`aluguel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(7) NOT NULL,
  `dataDevolucao` VARCHAR(7) NOT NULL,
  `idFuncionario` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `valor` FLOAT NULL DEFAULT NULL,
  `metodo_pagamento` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `idFuncionario` (`idFuncionario` ASC) VISIBLE,
  INDEX `idCliente` (`idCliente` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = latin1;
