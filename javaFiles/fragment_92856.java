public static void main(String[] args) throws Exception {       
        String filePath = "D:\\test\\test.py";      
        ProcessBuilder pb = new ProcessBuilder()
            .command("python", "-u", filePath, "main33");        
        Process p = pb.start(); 
        BufferedReader in = new BufferedReader(
            new InputStreamReader(p.getInputStream()));
        StringBuilder buffer = new StringBuilder();     
        String line = null;
        while ((line = in.readLine()) != null){           
            buffer.append(line);
        }
        int exitCode = p.waitFor();
        System.out.println("Value is: "+buffer.toString());                
        System.out.println("Process exit value:"+exitCode);        
        in.close();
    }