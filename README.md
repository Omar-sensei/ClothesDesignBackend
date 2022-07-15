# backend



## Getting started

Start the Server with Intellig .
you need at first a database for that instal MySQL Workbench and make a Connection with the name root and Password root

specify the Schame of the database as following


 ------------------------------------------------------------------------------------------------------------------------
create database designme ;

use designme;

create table designs(
id int not null auto_increment,
title varchar(1500) ,
category varchar(1500),
image varchar(1500),
about varchar(5999),
likes int,
size varchar(1500),
color varchar(1500),
primary key(id)
);


INSERT INTO designs (title, category, image, about,likes,size,color)
VALUES ("Summer T-shirt","Women","/images/womanwhiteblacktshirt.jpg","The T-shirt you would like to wear in Summer",0,"Medium",
              "white and Black");

select * from designs ;



----------------------------------------------------------------------------------------------------------------------



Start your android App and add new Designs if you want
