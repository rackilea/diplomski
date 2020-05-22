Task<String> task = new Task<String>() {
     @Override 
     protected Integer call() throws Exception {
          try {
             Process p = pb.start();
             BufferedReader stdInput = new BufferedReader(new
             InputStreamReader(p.getInputStream()));
             // read the output from the command
             while((line=stdInput.readLine())!=null){
                  System.out.println(line);
                  // To update the textarea
                  updateMessage(line);
             }
          }
          catch (Exception e1) {
             e1.printStackTrace();
          }
     }
};