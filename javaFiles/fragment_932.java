try
            {               
                 ServerSocket servsock=new ServerSocket(12345);
                 Socket sock = servsock.accept();
                     int bufferSize = 65536;
                     byte[] mybytearray = new byte[bufferSize];
                     BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                     OutputStream os = sock.getOutputStream();
                     int loopcount = (int) (file.length()/bufferSize)+(file.length()%bufferSize==0?0:1);
                     System.out.println("loopcount: "+loopcount);
                     os.write(loopcount);
                     os.flush();
                     for(int i = 0; i < loopcount; i ++)
                     {
                         System.out.println(i);
                     bis.read(mybytearray, 0, mybytearray.length);

                     //System.out.println(mybytearray.length);
                     os.write(mybytearray, 0, mybytearray.length);
                     os.flush();
                     }

                     os.close();
                     sock.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }