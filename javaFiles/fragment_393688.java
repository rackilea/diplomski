public void execute(String[] code){

        try{
            ProcessBuilder pb=new ProcessBuilder(code);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            BufferedReader inStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while(inStreamReader.readLine() != null){
                System.out.println(inStreamReader.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }