BufferedReader br = null;

        try {

            String currentLine;
                        int count;

            br = new BufferedReader(new FileReader("a.txt"));

            while ((currentLine = br.readLine()) != null && currentLine.contains("AppSample")) {
                count++;
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

System.out.println("Count: "+count);