else if (num == 1 && !args[0].equals("-n"))
{
     String cmd = "select * from all_users where regexp_like(username, '" + args[0] + "', 'i') order by username";
     System.out.println(cmd);
     String users[] = ora.doSql(cmd);
     for (String u: users)
         System.out.println(u);
 }