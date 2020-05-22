Thread thread1 = new Thread()  
{  
    public void run()  
    {  
        while(true)
        {
            if(writeNow == true)  
            {  
                try 
                {  
                    fos.write(s.getBytes());  
                } 
                catch (IOException e) 
                {  
                     e.printStackTrace();  
                }  

                writeNow = false;  
            }

            try
            {
                Thread.sleep(100); //sleep for 100 ms
            }
            catch (InterruptedException e) 
            {  
                 Log.d('', e.getMessage());  
            }  
        }
    }  
 };