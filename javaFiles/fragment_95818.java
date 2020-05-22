public static void main(String[] args) throws Exception {
    Process proc = Runtime.getRuntime().exec("cmd /c ipconfig");

    BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    String line = null;
    while((line = reader.readLine()) != null){
        System.out.println(line);
    }
}