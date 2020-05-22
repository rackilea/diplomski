for(int i=0;i<numRows;i++)
{
   String Usernames = rs.getString("Username");
   String Password = rs.getString("Password");
   String getAcc = rs.getString("UserType");
   rs.next();
   if(Usernames.contains(UsernameIn.trim())&&Password.contains(PasswordIn.trim()))
   {
      if(getAcc.trim().equals("admin")) {
          clear();
          AdminUser.UTypeAdmin(args, UsernameIn, rs, dbTable(), path);
      }
      if(getAcc.trim().equals("standard")) {
          clear();
          StandardUser.UTypeStandard(args, UsernameIn, rs, dbTable(),path);
      }
   }
}

// We have traversed all rows but not found matching user
System.out.println("Invalid Credentials Entered");
Thread.sleep(2000);
clearandreset(args);