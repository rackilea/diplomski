new Thread(new Runnable() {

          @Override
          public void run() {

               byte[] buffer = new byte[128];  // buffer store for the stream
               int bytes; // bytes returned from read()

               try {
                     while (true){ // continuously read buffer
                          bytes = ClientInPutStream.read(buffer);
                          byte[] readBuf = buffer;
                          String strIncom = new String(readBuf, 0, bytes);                 // create string from bytes array
                          msg2 += strIncom;
                          showmsg();
                     }
                }catch (Exception e){msg=e.toString();showError();}
          }

 }).start();