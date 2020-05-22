...
System.out.println("Enter username");
String username = keyboard.nextLine();

if(user_map.containsKey(username))
{
   System.out.println("Enter password");
   String password = keyboard.nextLine();

   if (user_map.get(username).doesPasswordEqual(password)) {
       System.out.println("Hello");
   } else {
       System.out.println("Incorrect password");
   }
}