try {
        String [] commands = {"cmd.exe","/C","time"};
         Process p = Runtime.getRuntime().exec(commands);
         OutputStream out = p.getOutputStream();
         BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
         String line = reader.readLine(); // read the first line
         System.out.println(line);

         // write to ouput
         out.write("sample".getBytes());
         out.flush();
         line = reader.readLine();
         System.out.println(line);
         line = reader.readLine();
         System.out.println(line);
         p.destroy();
    } catch (IOException e1) {}