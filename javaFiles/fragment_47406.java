try
{
   loadCatalog(...);
}
catch(FileNotFoundException ex)
{
    ex.printStackTrace(); 
}
catch(IOException ex)
{
    ex.printStackTrace(); 
}
catch(DataFormatException ex)
{
    ex.printStackTrace(); 
}