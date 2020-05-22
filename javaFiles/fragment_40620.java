public static void main(String[] args) throws Exception {
     ProcessBuilder pb =
                new ProcessBuilder("cmd.exe", "/C", "echo", "%JAVA_HOME%");
     Map<String, String> env = pb.environment();
     env.put("JAVA_HOME", "c/User/Programs/JDK...");
     Process p = pb.start();
     BufferedReader br  = new BufferedReader(new InputStreamReader(p.getInputStream()));
     String line = "";
     while((line=br.readLine()) != null){
         System.out.println(line);
     }
     try {
         int exitValue = p.waitFor();
         System.out.println("\n\nExit Value is " + exitValue);
     } catch (InterruptedException e) {
            e.printStackTrace();
     }
}