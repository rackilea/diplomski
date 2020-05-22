public static void main(String[] args) throws FileNotFoundException, IOException {
    // TODO code application logic here
    double sum = 0.0;
    FileInputStream fs = new FileInputStream("C:/Analysis/RL004.TXT");
    BufferedReader br = new BufferedReader(new InputStreamReader(fs));
    String line;
    while((line = br.readLine()) != null){
        String num = line.substring(34, 47);

        double i = Double.parseDouble(num);
        sum = sum + i;
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        System.out.println(Double.valueOf(twoDForm.format(i)));
    }
        System.out.println("SUM = " + Double.valueOf(twoDForm.format(sum)));
}
}