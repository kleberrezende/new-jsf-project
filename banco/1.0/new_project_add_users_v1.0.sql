-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.58-1ubuntu1
-- -------------------------------------------------------------------------------------------
-- ATENÇÃO -> criar o schema com Default Collation como UTF8-utf8_general_ci --
-- -------------------------------------------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


USE new_project;
INSERT INTO `new_project`.`Perfil` (`id`,`dataCadastro`,`dataAlteracao`,`idUsuarioAlt`,`descricao`,`titulo`) VALUES 
 (1,'1980-01-01 00:00:00','1980-01-01 00:00:00',0,'ROLE_ADMIN','Administrador'),
 (2,'1980-01-01 00:00:00','1980-01-01 00:00:00',0,'ROLE_SUSER','Super usuário'),
 (3,'1980-01-01 00:00:00','1980-01-01 00:00:00',0,'ROLE_BASICO','Básico');

INSERT INTO `new_project`.`Usuario` (`id`,`dataCadastro`,`dataAlteracao`,`idUsuarioAlt`,`enabled`,`name`,`password`,`username`) VALUES 
 (1,'1980-01-01 00:00:00','1980-01-01 00:00:00',0,0x01,'Admin','d404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db','admin');

INSERT INTO `new_project`.`UsuarioPerfil` (`id`,`perfil_id`,`usuario_id`) VALUES 
 (1,1,1);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
