BufferedReader br = new BufferedReader(new FileReader("data.txt"));
List<String> aisLines = new ArrayList<String>();
String line, cvsSplitBy = ",";
try {
    while ((line = br.readLine()) != null) {
        if(line.charAt(0) == '!') {
            String[] cols = line.split(cvsSplitBy);
            if(cols.length>=8) {
                line = "";
                for(int i=0; i<cols.length-1; i++) {
                    if(i == cols.length-2) {
                        line = line + cols[i];
                    } else {
                        line = line + cols[i] + ",";
                    }
                }
                aisLines.add(line);
            } else {
                aisLines.add(line);
            }
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}