public static void main(String[] args)
{
  try
  {
   User user = new User();
   user.setFirstName("david99world");
   DaoFactory factory = new DaoFactory();
   factory.create(user);
  }
   catch(Exception ex)
  {
   ex.printStackTrace(System.out);
  }
}