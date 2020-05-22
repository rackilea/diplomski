Statement stm = DataCon.getDataCon().createStatement(); 
String stm1 = "SET @num := 0"; 
String stm2 = "UPDATE tblstaff SET staffid = @num := (@num+1)"; 
String stm3 = "ALTER TABLE tblstaff AUTO_INCREMENT = 1"; 
stm.addBatch(stm1); 
stm.addBatch(stm2); 
stm.addBatch(stm3); 
stm.executeBatch(); 
stm.close();