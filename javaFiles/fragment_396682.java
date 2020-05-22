BufferedReader br = null;
    try {
        String sCurrentLine;
        br = new BufferedReader(new FileReader("C:\\testing.txt"));//file name with path
        while ((sCurrentLine = br.readLine()) != null) {
               String[] strArr = sCurrentLine.split("\\+");
               for(String str:strArr){
                    System.out.println(str);
                      }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }