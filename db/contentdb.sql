-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema contentdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema contentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contentdb` DEFAULT CHARACTER SET utf8 ;
USE `contentdb` ;

-- -----------------------------------------------------
-- Table `contentdb`.`content`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contentdb`.`content` ;

CREATE TABLE IF NOT EXISTS `contentdb`.`content` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` TEXT(1000) NULL,
  `username` VARCHAR(45) NULL,
  `hyperlink` VARCHAR(250) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contentdb`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contentdb`.`comments` ;

CREATE TABLE IF NOT EXISTS `contentdb`.`comments` (
  `int` INT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(45) NOT NULL,
  `content_id` INT NOT NULL,
  PRIMARY KEY (`int`),
  INDEX `fk_comments_content_idx` (`content_id` ASC),
  CONSTRAINT `fk_comments_content`
    FOREIGN KEY (`content_id`)
    REFERENCES `contentdb`.`content` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `contentdb`.* TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `contentdb`.`content`
-- -----------------------------------------------------
START TRANSACTION;
USE `contentdb`;
INSERT INTO `contentdb`.`content` (`id`, `title`, `description`, `username`, `hyperlink`) VALUES (1, 'SCR18-004 Congressional Redistricting', 'test', 'robthompson', 'https://leg.colorado.gov/bills/scr18-004');
INSERT INTO `contentdb`.`content` (`id`, `title`, `description`, `username`, `hyperlink`) VALUES (2, 'SB18-197 AG port of entry', 'test', 'robthompson', 'https://leg.colorado.gov/bills/sb18-197');

COMMIT;


-- -----------------------------------------------------
-- Data for table `contentdb`.`comments`
-- -----------------------------------------------------
START TRANSACTION;
USE `contentdb`;
INSERT INTO `contentdb`.`comments` (`int`, `comment`, `content_id`) VALUES (1, 'This bill is critically important', 1);

COMMIT;

