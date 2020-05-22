public static void main(String[] args) {
    // TODO Auto-generated method stub
    Process p=null;
    StringBuffer output = new StringBuffer();
    String command= "netstat  -p ";
    try{
        p = Runtime.getRuntime().exec(command);
        p.waitFor();
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(p.getInputStream()));

                    String line = "";
        while ((line = reader.readLine())!= null) {
            if(line.matches("^tcp.*2406.*"))
            output.append(line + "\n");

            //reader.close();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

     System.out.println(output);
}