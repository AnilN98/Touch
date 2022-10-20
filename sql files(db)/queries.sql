use touch;

create table touchregisters(id int(10) primary key auto_increment, registerName varchar(30), registerPassword varchar(20), registerEmail varchar(40), 
registerMobile varchar(15)) ENGINE = InnoDB auto_increment = 1;

desc touchregisters;

select * from touchregisters ;