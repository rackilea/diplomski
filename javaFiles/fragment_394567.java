CREATE TRIGGER IF NOT EXISTS increment_tax_number 
    AFTER INSERT ON Person_Table 
    BEGIN
        UPDATE Person_Table SET TxnNo = 'Txn no '||new.OID WHERE OID =  new.OID;
    END;
INSERT INTO Person_Table VALUES(null,'not a valid tax number as yet','Fred',15000,'2018-01-01','blah','more blah');
INSERT INTO Person_Table VALUES(null,'not a valid tax number as yet','Bert',25000,'2018-03-04','blah','more blah');
SELECT * FROM Person_Table;