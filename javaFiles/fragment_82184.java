FileOutputStream out1 = new FileOutputStream("File Ricevuti\\"+namef);
                    byte[] buf = new byte[socket.getReceiveBufferSize()];
                    int len = 0;
                    while ((len = inp.read(buf)) != -1) {
                        out1.write(buf, 0, len);
                        out1.flush();
                        //out1.flush();
                    }

                    out1.close();