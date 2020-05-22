String date = "your_date_formatted";
Date dt= new SimpleDateFormat("date_format").parse(date);
java.sql.Date sqlDate = new java.sql.Date(dt.getTime()); 

Connection con = ...;
PreparedStatement p = con.prepareStatement("insert into table(date_field) values(?))");
p.setDate(1, dt);