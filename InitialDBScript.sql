DROP DATABASE IF EXISTS test;
CREATE DATABASE test;

use test;

create table `test`.`test`(
`id` int(11) not null auto_increment,
`name` varchar(100) not null,
`isNeedForAssembly` bit(1) not null default b'0',
`amount` int(11) not null,
primary key (`id`))
engine = InnoDB
default character set = utf8;

insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Материнская плата',1,12);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Процессор',1,50);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Блок питания',0,100);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Видеокарта',1,30);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Корпус',1,50);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Монитор',1,20);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('CD-ROM',0,30);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Floppy',0,10);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('RAID-контроллер',0,10);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('HDD',1,25);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('ОЗУ',1,40);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Принтер',0,12);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Сканер',0,21);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Клавиатура',1,45);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Мышь',1,70);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('DVD-ROM',0,21);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('DVD-RW',0,50);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Blue-Ray привод',0,50);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('USB-hub',0,25);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Веб-камера',0,10);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('ИБП',0,50);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('COM-адаптер',0,5);
insert into `test`.`test`(`name`,`isNeedForAssembly`,`amount`) values ('Штрих-сканнер',0,2);
