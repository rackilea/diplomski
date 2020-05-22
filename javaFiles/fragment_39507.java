CREATE VIEW Query1 AS
SELECT Orders.ID AS OrderID,
       Orders.CustID,
       Orders.ItemID,
       Customers.CustName
FROM Orders
LEFT JOIN Customers ON Orders.CustID = Customers.ID;