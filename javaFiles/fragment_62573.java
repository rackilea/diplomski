SELECT 
ROUND(SUM(case when Updated_Date BETWEEN $P{secondYear}"-03-01" AND $P{secondYear}"-03-31" then Amount else 0 end),2) AS `March` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{secondYear}"-02-01" AND $P{secondYear}"-02-29" then Amount else 0 end),2) AS `February` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{secondYear}"-01-01" AND $P{secondYear}"-01-31" then Amount else 0 end),2) AS `January` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-12-01" AND $P{firstYear}"-12-31" then Amount else 0 end),2) AS `December` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-11-01" AND $P{firstYear}"-11-31" then Amount else 0 end),2) AS `November` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-10-01" AND $P{firstYear}"-10-31" then Amount else 0 end),2) AS `October` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-09-01" AND $P{firstYear}"-09-31" then Amount else 0 end),2) AS `September` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-08-01" AND $P{firstYear}"-08-31" then Amount else 0 end),2) AS `August` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-07-01" AND $P{firstYear}"-07-31" then Amount else 0 end),2) AS `July` ,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-06-01" AND $P{firstYear}"-06-31" then Amount else 0 end),2) AS `June`, 
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-05-01" AND $P{firstYear}"-05-31" then Amount else 0 end),2) AS `May`,
ROUND(SUM(case when Updated_Date BETWEEN $P{firstYear}"-04-01" AND $P{firstYear}"-04-31" then Amount else 0 end),2) AS `April` 
FROM VAT