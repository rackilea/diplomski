boolean founded = false;
for(int i=0;i<numRows;i++)
{
    String Usernames = rs.getString("Username");
    String Password = rs.getString("Password");
    String getAcc = rs.getString("UserType");
    rs.next();

    if(Usernames.trim().equals(UsernameIn)&&Password.trim().equals(PasswordIn))
    {
        founded = true;
        start.writeToFile("ConToDatabase Class|Username: "+UsernameIn+" and Password: "+PasswordIn+" Accepted");

        if(getAcc.trim().equals("admin"))
        {
            start.writeToFile("ConToDatabase Class|Authenticated user identified as \"admin\", Entering AdminUser Class|UTypeAdmin Method");
            clear();
            AdminUser.UTypeAdmin(args, UsernameIn, rs, dbTable(), path);
        }

        if(getAcc.trim().equals("standard"))
        {
            start.writeToFile("ConToDatabase Class|Authenticated user identified as \"standard\", Entering StandardUser Class|UTypeStandard Method");
            clear();
            StandardUser.UTypeStandard(args, UsernameIn, rs, dbTable(),path);
        }
    }
}

if(!founded)
{ 
  start.writeToFile("ConToDatabase Class|User invalid, reset application");
  System.out.println("Invalid User, Resetting...");
  Thread.sleep(2000);
  ConToDatabase.clearandreset(args);
}