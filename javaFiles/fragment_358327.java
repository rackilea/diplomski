String[] packageName = {"com.abc.abc","com.def.def"};
for(int i = 0; i < packageName.length; i++)
{
   try 
   {
      addDisallowedApplication(packageName[i]);
   } 
   catch (NameNotFoundException e) 
   {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
}