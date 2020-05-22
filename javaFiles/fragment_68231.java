public ArrayList<String> getProcessusList(){

        ArrayList<String> ss=new ArrayList<String>();
        try {
            String line;
            Process p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                String[] se=line.split(" =\n");
                for(String sd:se){
                    String[] sa = sd.split("\\s\\s+");
                    if (sa.length>1)
                        ss.add(sd);
                }
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return ss;
    }