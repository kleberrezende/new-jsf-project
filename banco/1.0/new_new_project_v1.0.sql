SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `new_project` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `new_project` ;

-- -----------------------------------------------------
-- Table `new_project`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `new_project`.`Usuario` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `dataCadastro` DATETIME NOT NULL,
  `dataAlteracao` DATETIME NOT NULL,
  `idUsuarioAlt` BIGINT(20) NOT NULL,
  `enabled` BIT(1) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `password` VARCHAR(130) NOT NULL,
  `username` VARCHAR(21) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `usuario_nome_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `new_project`.`Perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `new_project`.`Perfil` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `dataCadastro` DATETIME NOT NULL,
  `dataAlteracao` DATETIME NOT NULL,
  `idUsuarioAlt` BIGINT(20) NOT NULL,
  `descricao` VARCHAR(21) NOT NULL,
  `titulo` VARCHAR(21) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `perfil_descricao_UNIQUE` (`descricao` ASC),
  UNIQUE INDEX `perfil_titulo_UNIQUE` (`titulo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `new_project`.`UsuarioPerfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `new_project`.`UsuarioPerfil` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT(20) NOT NULL,
  `perfil_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `perfil_usuario_UNIQUE` (`usuario_id` ASC, `perfil_id` ASC),
  INDEX `fk_UsuarioPerfil_Usuario_idx` (`usuario_id` ASC),
  INDEX `fk_UsuarioPerfil_Perfil_idx` (`perfil_id` ASC),
  CONSTRAINT `fk_UsuarioPerfil_Usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `new_project`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioPerfil_Perfil`
    FOREIGN KEY (`perfil_id`)
    REFERENCES `new_project`.`Perfil` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `new_project`.`new_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `new_project`.`new_table` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `dataCadastro` DATETIME NOT NULL,
  `dataAlteracao` DATETIME NOT NULL,
  `idUsuarioAlt` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `new_project`.`Configuracoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `new_project`.`Configuracoes` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `dataCadastro` DATETIME NOT NULL,
  `dataAlteracao` DATETIME NOT NULL,
  `idUsuarioAlt` BIGINT(20) NOT NULL,
  `temaSistema` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `new_project`.`MenuFavorito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `new_project`.`MenuFavorito` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT(20) NOT NULL,
  `menuItem_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_MenuFavoritos_Usuario_idx` (`usuario_id` ASC),
  UNIQUE INDEX `menuFavorito_usuario_id_menuItem_UNIQUE` (`usuario_id` ASC, `menuItem_id` ASC),
  CONSTRAINT `fk_MenuFavoritos_Usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `new_project`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
