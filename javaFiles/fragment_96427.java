try 
         {  
                inputStream = new BufferedInputStream(reader.getContentInputStream(),16384);

                return new InputSource(inputStream);
         }
         finally
         {
             if(inputStream!=null)
                try 
                {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
         }