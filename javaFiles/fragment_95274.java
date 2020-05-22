File fil = new File("C:\\Users\\Desktop\\kaycee2.csv");
    FileReader inputFil = new FileReader(fil);
    BufferedReader in = new BufferedReader(inputFil);
    ArrayList<Double> tall = new ArrayList<>();
    while(in.ready()){ 
        String s = in.readLine().trim();
        if(!s.isEmpty()){
           tall.add(Double.parseDouble(s);
        } 
    }