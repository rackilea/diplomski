BufferedReader br = new BufferedReader(new FileReader("file.txt"));
try {
    String line = br.readLine();

    while (line != null) {

        line = br.readLine();
        String[] splitStr=line.split(", ");
        if(splitStr.length==3){
            int empID=Integer.parseInt(splitStr[0]);
            String fullName=splitStr[1];
            double wage=Double.parseDouble(splitStr[2]);
        }
    }

} finally {
    br.close();
}