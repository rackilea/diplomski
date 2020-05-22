boolean open = false;
try
{
  org.apache.commons.io.FileUtils.touch(myFile);
  open = true;
}
catch
{   
    open = false;
}

if(open == false){
    // Show notification message.
}