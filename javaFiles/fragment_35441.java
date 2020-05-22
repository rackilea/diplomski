private void loop() {
        while (true){
           try{
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

               //other logic goes here...
               if(br.readLine().equalsIgnoreCase("Q")){
                   return; // You're done and you are returning to the caller.
               }
           }
           catch (IOException ioe) {
               System.out.println("IO error trying to read your selection");
           }
        }
    }

    public static void main(String[] args) {
        loop();
    }