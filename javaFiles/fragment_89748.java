select can_delete_contract(1); // true

insert into CUSTOMER_CONTRACT values (1);

select can_delete_contract(1); // true

insert into CUSTOMER_CONTRACT values (1);
insert into CUSTOMER_CONTRACT_REF values(1, 1);

select can_delete_contract(1); // false