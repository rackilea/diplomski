class PingHost 
{
        public static void main(String[] args) 
        {
            String ip = "www.google.com";
            String pingResult = "";

            String pingCmd = "ping " + ip;
            try 
            {
                Runtime r = Runtime.getRuntime();
                Process p = r.exec(pingCmd);

                BufferedReader in = new BufferedReader(new
                InputStreamReader(p.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) 
                {
                    System.out.println(inputLine);
                    pingResult += inputLine;
                }
                in.close();

            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }