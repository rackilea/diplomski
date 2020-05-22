InputStream in =  new FileInputStream( f );

                byte[] buf = new byte[socket2.getSendBufferSize()];
                int len = 0;
                while ((len = in.read(buf)) != -1) {
                    out.write(buf, 0, len);

                }
                in . close ();
                out.close();