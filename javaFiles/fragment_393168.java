@Override
public void run() {
  try
   {
    read.readChat(line);
   }catch(Exception ex)
   {
     ex.printStackTrace();
   }
}