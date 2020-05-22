String query =
 "SELECT cus.id, pLead.id AS leadId, cus.code AS custCode, cus.primaryName AS custName, " + 
 "cus.primaryKhmerName AS custkhmerName, pLead.phoneNo, prot.englishName AS propertyType, " + 
 "pro.houseno AS houseNo, pro.streetno AS streetNo, pLead.address " +   
 "FROM Customer cus, Contract con, Property pro, PropertyType prot, Lead pLead " + 
 "WHERE cus.id = con.customer AND prot.id = pro.propertyType AND pro.id = con.property AND cus.primaryLead = pLead.id ";