CREATE SCHEMA IF NOT EXISTS `locadora` DEFAULT CHARACTER SET utf8 ;
USE `locadora` ;

-- -----------------------------------------------------
-- Table `locadora`.`Supervisor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`Supervisor` (
  `idSupervisor` INT NOT NULL AUTO_INCREMENT,
  `SSN_Supervisor` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSupervisor`));


-- -----------------------------------------------------
-- Table `locadora`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`Funcionario` (
  `idAtendente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` INT NOT NULL,
  `Supervisor_idSupervisor` INT NOT NULL,
  PRIMARY KEY (`idAtendente`, `Supervisor_idSupervisor`),
  CONSTRAINT `fk_Funcionario_Supervisor1`
    FOREIGN KEY (`Supervisor_idSupervisor`)
    REFERENCES `locadora`.`Supervisor` (`idSupervisor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `locadora`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`Cliente` (
  `Clicpf` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Clicpf`));


-- -----------------------------------------------------
-- Table `locadora`.`Veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`Veiculo` (
  `IdVeiculo` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(15) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `devolvido` TINYINT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`IdVeiculo`, `Cliente_idCliente`),
  CONSTRAINT `fk_Veiculo_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `locadora`.`Cliente` (`Clicpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `locadora`.`Funcionario_has_Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`Funcionario_has_Cliente` (
  `Funcionario_idAtendente` INT NOT NULL,
  `Funcionario_Supervisor_idSupervisor` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`Funcionario_idAtendente`, `Funcionario_Supervisor_idSupervisor`, `Cliente_idCliente`),
  CONSTRAINT `fk_Funcionario_has_Cliente_Funcionario1`
    FOREIGN KEY (`Funcionario_idAtendente` , `Funcionario_Supervisor_idSupervisor`)
    REFERENCES `locadora`.`Funcionario` (`idAtendente` , `Supervisor_idSupervisor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_has_Cliente_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `locadora`.`Cliente` (`Clicpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    INSERT INTO cliente VALUES (1,"Locadora");
    INSERT INTO cliente VALUES (31231231,"Karem");
    INSERT INTO cliente VALUES (236612,"Cleiton");
    INSERT INTO veiculo (placa,modelo,cor,devolvido,Cliente_idCliente) VALUES ("AFD1213","BMW","azul",true,1);
    INSERT INTO veiculo (placa,modelo,cor,devolvido,Cliente_idCliente) VALUES ("ADS312","Gol","Vermelho",false,236612);
    INSERT INTO supervisor(SSN_Supervisor,nome) VALUES (31231,"Eduardo");
    INSERT INTO funcionario(nome,cpf,Supervisor_idSupervisor) VALUES ("Jeverson",312321312,1);
    
    UPDATE cliente SET nome="Francisca" WHERE Clicpf = 31231231;
    DELETE FROM cliente WHERE Clicpf = 31231231;
    SELECT * FROM veiculo WHERE devolvido = true;