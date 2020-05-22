if(!alreadyRunning())
        {
            try
            {
                // YOUR CODE THAT RUNS  
                while(true)
                {
                    //YOUR 
                    Thread.sleep(35000);                        
                }

            }
            finally
            {

                new File("f:\\test.lock").deleteOnExit();               
            }
        }