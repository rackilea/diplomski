try
                { 
                    Socket sock = new Socket("127.0.0.1", 12345);
                    byte[] mybytearray = new byte[65536];
                    System.out.println("1");
                    InputStream is = sock.getInputStream();
                    System.out.println("2");
                    File recievedFile=new File(fileName+"_res.jpg");
                    System.out.println("3");
                    recievedFile.createNewFile();
                    System.out.println("4");           
                    FileOutputStream fos = new FileOutputStream(recievedFile);
                    System.out.println("5");
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    System.out.println("6");
                    int loopcount = is.read();

                    for(int i = 0; i < loopcount; i++)
                    {
                        int bytesRead = is.read(mybytearray, 0, mybytearray.length);
                        System.out.println(bytesRead);
                        System.out.println("7");
                        bos.write(mybytearray, 0, bytesRead);
                        System.out.println("8");
                        bos.flush();
                    }

                    System.out.println("9");
                    bos.close();
                    sock.close();  
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }