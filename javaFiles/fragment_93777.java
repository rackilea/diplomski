public static void main(String[] args) {        
    try {

        String filePath = "./foo.txt";
        // Use "dxdiag /t" variant to redirect output to a given file
        ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","dxdiag","/t",filePath);
        System.out.println("-- Executing dxdiag command --");
        Process p = pb.start();
        p.waitFor();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        System.out.println(String.format("-- Printing %1$1s info --",filePath));
        while((line = br.readLine()) != null){
            if(line.trim().startsWith("Card name:") || line.trim().startsWith("Current Mode:")){
                System.out.println(line.trim());
            }
        }
    } catch (IOException | InterruptedException ex) {
        ex.printStackTrace();
    }

}