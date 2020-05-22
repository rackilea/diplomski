create table loan( id int, loan_amount  int, loan_duration int);
insert into loan values
(1,60000,3),(2,80000,4);
create table loan_repayment (id int,loan_id int,amount int,month int,status varchar(20));
insert into loan_repayment values
(1 ,1 ,20000,1,'Pending'),(2 ,1 ,20000,2,'Pending'),(3 ,1 ,20000,3,'Pending'),
(4 ,2 ,20000,1,'Pending'),(5 ,2 ,20000,2,'Pending'),(6 ,2 ,20000,3,'Pending'),
(7 ,2 ,20000,4,'Pending');