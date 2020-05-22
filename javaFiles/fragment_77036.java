final File parentDirectory = sets.getParentFile();
if (!parentDirectory.exists()) // checks that directory exists
{
   parentDirectory.mkdirs();   
}
if (!sets.exists()) // checks that file exists
{
   sets.createNewFile();
}