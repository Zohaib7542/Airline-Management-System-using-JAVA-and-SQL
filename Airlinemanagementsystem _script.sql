create database airlinemanagementsystem;
use airlinemanagementsystem;

create table login(username varchar(20),password varchar(20));
insert into login values("admin","admin");

select * from login;

create table passenger(name varchar(20) 
, nationality varchar(20),
 phone varchar(15),
 address varchar(50), adhaar varchar(20), gender varchar(20));
 
 select * from passenger;
 
 create table flight(f_code varchar(20),f_name varchar(20),source varchar(40),destination varchar(40));
 
 describe flight;
 
 insert into flight values("1001","AI-1212","Delhi","Mumbai");
  insert into flight values("1002","AI-1245","Delhi","Goa");
   insert into flight values("1003","AI-1211","Delhi","Patna");
    insert into flight values("1004","AI-1345","Delhi","Chennai");
    insert into flight values("1005","AI-1765","Delhi","Bangaluru");
    insert into flight values("1005","AI-1765","Mumbai","Bangaluru");
    insert into flight values("1005","AI-1765","Patna","Kolkata");
    insert into flight values("1006","AI-1705","Hyderabad","Chennai");
    insert into flight values("1007","AI-1395","Ahemdabad","Lucknow");
   
    
    
    select * from flight;
    
    truncate table flight;
    
    create table reservation(PNR varchar(15),TICKET varchar(20), adhaar varchar(20),name varchar(20),nationality varchar(30),flightname varchar(15),flightcode varchar(20),src varchar(30),des varchar(30),date varchar(30));
    
    select * from reservation;
    
    create table cancel(pnr varchar(20),name varchar(40),cancelno varchar(20),fcode varchar(20),date varchar(30));
    
    select * from cancel;
    
    