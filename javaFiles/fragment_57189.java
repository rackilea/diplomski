String sql = "INSERT INTO `JavaChatBankDB`.`Customers36` (`CustId`,`CustPassword`, `CustFirstName`, `CustLastName`, `CustAddress`, `CustEmail`)"
               + "VALUES ('"+custId+"','"+custPassword+"','"+custFname+"','"+custLname+"','"+address+"','"+email+"')";
int answer = stmt.executeUpdate(sql);
[...]
custId = id;
custPassword = pw;
custFname = fn;
custLname = ln;
address = add;
email = em;