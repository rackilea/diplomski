BufferedReader reader = ...;
try{
    reader =  new BufferedReader(new   FileReader(path));
}
finally{
  try{
    reader.close();
   }
  catch(IOException e) {...}
}