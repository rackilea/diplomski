public static class SerialReader implements Runnable 
    {
        InputStream in;
        CommPort serialport;

        public SerialReader (InputStream in, CommPort port)
        {
            this.in = in;
            serialport = port;

        }

        public void run ()
        {
            byte[] buffer = new byte[1024];
            int len = -1;
            try
            {
                String txt = "";
                long startTime = System.currentTimeMillis(); //fetch starting time
                while(( len = this.in.read(buffer)) > -1 & (System.currentTimeMillis()-startTime)<6000)
                {
                    System.out.print(new String(buffer,0,len));
                    txt = txt + (new String(buffer,0,len));
                }
              PrintWriter writer = new PrintWriter("Patient" + startTime + ".txt", "UTF-8");
              writer.println(txt);
              writer.close();
              this.in.close();
              serialport.close();

            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }

        }


    }