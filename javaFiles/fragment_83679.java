String path;
String[] params = new String [3];

                    params[0] = "D:\\prog.exe";
        params[1] = picA+".jpg";
        params[2] = picB+".jpg";

        try {
            final Process p = Runtime.getRuntime().exec(params);
            Thread thread = new Thread() {
                public void run() {
                    String line;
                    BufferedReader input =
                       new BufferedReader
                         (new InputStreamReader(p.getInputStream()));

                     while ((line = input.readLine()) != null)
                         System.out.println(line);


                     input.close();
               } catch (IOException e) {System.out.println(" procccess not read"+e);}
            };
            thread.start();
            int result = p.waitFor();
            thread.join();
            if (result != 0) {
                System.out.println("Process failed with status: " + result);
            }