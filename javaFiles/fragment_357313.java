sql = "INSERT INTO USER 
        (USER_PK, ACCOUNTNUMBER, FIRSTNAME, LASTNAME, EMAIL ) 
       VALUES 
        (user.nextval, ?, ?, ?, ?)";
ps = conn.prepareStatement(sql);
ps.setString(1, accountNumber);
ps.setString(2, firstName);
ps.setString(3, lastName);
ps.setString(4, email);