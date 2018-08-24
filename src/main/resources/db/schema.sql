/*Table structure for table `participant` */
DROP TABLE IF EXISTS `Participant`;

CREATE TABLE `Participant` (
  `participantId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`participantId`,`name`)
);

/*Table structure for table `conference` */

//DROP TABLE IF EXISTS `conference`;

CREATE TABLE `conference` (
  `conferenceId` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `location` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`conferenceId`,`title`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `conference` */

/*Table structure for table `conference_participant` */
/*
DROP TABLE IF EXISTS `conference_participant`;

CREATE TABLE `conference_participant` (
  `conferenceId` INT(11) NOT NULL,
  `participant` INT(11) DEFAULT NULL,
  PRIMARY KEY (`conferenceId`),
  KEY `fk_participant_id` (`participant`),
  CONSTRAINT `fk_conference_id` FOREIGN KEY (`conferenceId`) REFERENCES `conference` (`conferenceId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_participant_id` FOREIGN KEY (`participant`) REFERENCES `participant` (`participantId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;*/

/*Data for the table `conference_participant` */
