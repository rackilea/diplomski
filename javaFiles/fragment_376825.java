truncate table A;
truncate table B;
truncate table C;
insert A (value) values (1);
insert B (value) values (2);
insert C (value) values (0);

select t7.*
from thing7 t7 
join
(   select A.value as Avalue, B.value as Bvalue, C.value as Cvalue
    from A
    cross join B
    cross join C
    order by a.value,b.value,c.value
) xDerived
on xDerived.Avalue=t7.A and xDerived.Bvalue=t7.B and xDerived.Cvalue=t7.C;
-- no rows returned