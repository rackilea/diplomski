try 
{
  //This already throws FileNotFoundException
  br = new BufferedReader(new FileReader(filename));
} 
catch(FileNotFoundException e)
{
  e.printStackTrace();
}