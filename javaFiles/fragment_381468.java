SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

try { 
   String userInput = jTextField3.getText();
   // Convert UserInput Into Date
   Date userDate = sdf.parse(userInput);

   pst = con.prepareStatement("insert into InOut (userDateColumn) Values(?)");

    // Send that is the input to the sql 
   pst.setString(1,userDate);