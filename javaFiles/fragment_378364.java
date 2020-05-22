try (FileOutputStream out = new FileOutputStream("people.bin");) 
{
   out.write(contentBytes);
}
catch(FileNotFoundException e)
{

}catch(IOException e){

}