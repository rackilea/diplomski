FileReader fr = new FileReader("input.txt");
 BufferedReader br = new BufferedReader(fr);
 FileWriter fw = new FileWriter("output.txt");

 BufferedWriter bw = new BufferedWriter(fw);

 Pattern pattern = 
    Pattern.compile("\\[  [0-6]\\]  (0.0- 1.0 sec)  0.00 KBytes  ([0-9]*.[0-9][0-9] Kbits/sec)");

    String lineString = null;
    while((lineString= br.readLine())!= null && !lineString.equals("Starting Test 2: Iperf TCP East....")){
        Matcher matcher = pattern.matcher(lineString);
        if(matcher.matches()){
            bw.write(lineString);
        }
    }
    bw.close();
    fw.close();
    br.close();
    fr.close();