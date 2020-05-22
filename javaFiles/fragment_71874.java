DROP TABLE IF EXISTS TABLE_BILLS;
CREATE TABLE IF NOT EXISTS TABLE_BILLS (
    COLUMN_BILL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
    COLUMN_BILL_USER_ID INTEGER,
    COLUMN_DESCRIPTION TEXT,
    COLUMN_AMOUNT INTEGER,
    COLUMN_DATE_STRING TEXT,
    COLUMN_COMPANY_NAME TEXT,
    COLUMN_CATEGORY TEXT)
    ;

-- Add the Testing data
INSERT INTO TABLE_BILLS (
    COLUMN_BILL_USER_ID, COLUMN_DESCRIPTION, COLUMN_AMOUNT, COLUMN_DATE_STRING, COLUMN_COMPANY_NAME,COLUMN_CATEGORY)
VALUES 
        (1,'blah',230,'04/03/19','cmpny','category')
        ,(1,'blah',500,'05/03/19','cmpny','category')
        ,(1,'blah',400,'04/04/19','cmpny','category')
        ,(1,'blah',600,'06/04/19','cmpny','category')
        ,(1,'blah',100,'04/03/19','cmpny','category')

        -- Extra data for another id to check exclusion
        ,(2,'blah',230,'04/03/19','cmpny','category')
        ,(2,'blah',500,'05/03/19','cmpny','category')
        ,(2,'blah',400,'04/04/19','cmpny','category')
        ,(2,'blah',600,'06/04/19','cmpny','category')
        ,(2,'blah',100,'04/03/19','cmpny','category')
;

SELECT sum(COLUMN_AMOUNT) AS Monthly_Total,substr(COLUMN_DATE_STRING,4) AS Month_and_Year
    FROM TABLE_BILLS 
    WHERE COLUMN_BILL_USER_ID = 1
  GROUP BY substr(COLUMN_DATE_STRING,4)
    ORDER BY substr(COLUMN_DATE_STRING,7,2)||substr(COLUMN_DATE_STRING,4,2)
;