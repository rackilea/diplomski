entityManager.executeUpdate("INSERT INTO aggregateTable (Select avgSalesA, avgSalesB, 
                             salesMade, tableA.employeeid FROM 
                             (SELECT avg(sales) as avgSalesA, count(salesMadeDaily) as 
                             SalesMadeTotal, employeeid FROM companyA GROUP BY 
                             employeeid) tableA INNER JOIN (SELECT 
                             avg(sales) as avgSalesB, employeeid FROM companyB group 
                             by employeeid) 
                             tableB ON tableA.employeeid = tableB.employeeid)");