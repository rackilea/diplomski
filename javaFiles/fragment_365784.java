if(inputList.get(0).equals("cd")
{
     File newDirectory = new File(inputList.get(1));
     if (!newDirectory.exists() || !newDirectory.isDirectory()) 
          /* handle error here */
          ....
     else
          /* otherwise change is successful */
          directory = newDirectory
     /* no need to actually start a process here */
}
// ...
else
{
     ProcessBuilder pb = new ProcessBuilder(inputList.get(0));
     pb.directory(directory);
     // ....
     p = pb.start();
}