public static void main(String[] args) throws UnknownHostException, IOException
        {
            log("Hello World!");

            Socket s = new Socket("192.168.1.8", 3000);
            BufferedReader r = new BufferedReader(new FileReader("./channel1.csv"));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            String line = null;
            int bytes = 0;
            int i = 0;
            while (true)
                {
                    line = ++i + "," + Math.sin(Math.toRadians((double) i));

                    System.out.println("Sending:" + line);
                    out.write(line + "\n");
                    out.flush();
                    bytes += line.length(

                }
        }