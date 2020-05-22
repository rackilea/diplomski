mysql> delimiter //
mysql> CREATE TRIGGER insert_trigger BEFORE INSERT ON Customer
    -> FOR EACH ROW
    -> BEGIN
    -> UPDATE Customer SET Price=Price-10 WHERE CustomerGroup=32 and CityCode=11;
    -> END;
    -> //