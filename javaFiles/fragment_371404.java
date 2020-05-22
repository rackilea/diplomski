while (in!=null && (n = in.read(buffer)) >= 0) {
               System.out.println("PipeWriter Processing: " + new  
                                String(Arrays.copyOfRange(buffer,0,n)));
                out.write(buffer,0,n);


                if(in.available()==0)   
                {
                    latch.countDown();
                    out.close();    
                    in.close();
                    break;
                }

            }
            System.out.println("Completed the PipeWriter loop");