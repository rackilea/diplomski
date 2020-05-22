if firstFieldValue.equals("") 

then SELECT FIELD1, FIELD2 FROM MYTABLE 

else  

SELECT FIELD1, FIELD2 FROM MYTABLE WHERE (FIELD1=? OR FIELD1='');

preparedStatementInstance.setString(1, this.firstFieldValue);