public int lineCounter(){
     BufferedReader br = new BufferedReader(new FileReader("file.txt"));
     int i =0;   
     try {
            String line = br.readLine();

            while (line != null) {
                i++;
            }
            String everything = sb.toString();
        } finally {
            br.close();
        }
        return i;
    }