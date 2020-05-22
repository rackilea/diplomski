public static void mergeTrain(File src1, File src2, File dest) throws IOException {      

    BufferedReader br1 = new BufferedReader(new FileReader(src1));
    BufferedReader br2 = new BufferedReader(new FileReader(src2));
    BufferedWriter bw = new BufferedWriter(new FileWriter(dest,true));

    String line1;
    String line2;

    try {
        while((line1 = br1.readLine()) != null
           && (line2 = br2.readLine()) != null) {            
            bw.append(line1 + " " + line2);
            bw.newLine();
        }
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }

    br1.close();
    br2.close();
    bw.close();
}