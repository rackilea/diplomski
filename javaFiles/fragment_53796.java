File file = new File(fileName); 
 FileInputStream fin = new FileInputStream(file);    
// dout.writeUTF(fileName); 
   byte[] readData = new byte[1024]; 
   fin.read(readData);  
   fin.close();
   dout.write(readData, 0, readData.length); 
   dout.flush();

  /* while((i = fin.read(readData)) != -1) 
   { 
       dout.write(readData, 0, i); 
   }*/  
                        //ta.appendText("\nImage Has Been Sent"); 

                        dout.flush();
                        fin.close(); 
                }catch(IOException ex)
                  {System.out.println("Image ::"+ex);} 

            }