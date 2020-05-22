//finish reading whatever's left in the buffers
outThread.join();
errThread.join();

// Read from an input stream
String line; 
BufferedReader input = new BufferedReader(new InputStreamReader(  proc.getErrorStream()));
line = input.readLine(); 

while(line != null) 
{ 
  System.out.println(line); 
  line = input.readLine(); 
} 

proc.waitFor();

 } catch (IOException e) {
 // new Notification(e.getMessage(),       
 Notification.Type.ERROR_MESSAGE).show(ui.getPage().getCurrent());
 e.printStackTrace();
 } catch (InterruptedException e) {
   new Notification(e.getMessage(),    
   Notification.Type.ERROR_MESSAGE).show(ui.getPage().getCurrent()); 
  }