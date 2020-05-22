Query:{[
select
    product0_.id as id1_18_1_,
    product0_.code as code2_18_1_,
    product0_.company_id as company_6_18_1_,
    product0_.importer_id as importer7_18_1_,
    product0_.name as name3_18_1_,
    product0_.quantity as quantity4_18_1_,
    product0_.version as version5_18_1_,
    company1_.id as id1_6_0_,
    company1_.name as name2_6_0_
from Product product0_
inner join Company company1_ on product0_.company_id=company1_.id
where product0_.id=?][1]