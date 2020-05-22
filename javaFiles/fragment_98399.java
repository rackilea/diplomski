public TravelData(File dataDir) {
    File[] listOfFiles = dataDir.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
        if (listOfFiles[i].isFile()) {

            InputStream inputStream = null;
            BufferedReader buffReader = null;
            try {
                inputStream = new FileInputStream(listOfFiles[i]);
                buffReader = new BufferedReader(new InputStreamReader(inputStream));
                String fileLine = buffReader.readLine();
                while(fileLine != null) {
                    ArrayList<String> line = new ArrayList<String>();
                    for(String value: fileLine.split("\t")) {
                        line.add(value);
                    }
                    lineConverter(line, dbDate);
                    fileLine = buffReader.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(buffReader != null) try { buffReader.close(); } catch (IOException e) { }
                if(inputStream != null) try { inputStream.close(); } catch (IOException e) { }
            }
        }
    }
}