ProcessBuilder builder = new ProcessBuilder(command);
            Map<String, String> environ = builder.environment();
//          for(Entry<String, String> entry : environ.entrySet()){
    //          System.out.println("ENV " +entry.getKey() + " " +entry.getValue());
      //      }
//          builder.redirectErrorStream(true);
            Process process = null;
            try {
                process = builder.start();

            InputStream is = process.getInputStream();

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {  
              //System.out.println(line);
                outfil=line;
            }

//          int exitVal = process.waitFor();
 //           System.out.println("Process exitValue: " + exitVal);