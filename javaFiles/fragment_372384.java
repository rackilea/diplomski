if(user1 !=null && user1.length() > 0 && pass1 !=null && pass1.length() > 0) 
{
     boolean comLogin = ComHelper.SendLogin(user1, pass1);
     if(comLogin)
     {
         //do something
     }
}