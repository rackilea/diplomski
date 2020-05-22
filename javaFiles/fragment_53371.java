//I read my file first
    BufferedReader br = new BufferedReader(new FileReader(new File("/home/mtataje/saved.txt")));
    String line;

    StringBuffer auxBuffer = new StringBuffer();

    while ((line = br.readLine()) != null) {
        auxBuffer.append(line);
        auxBuffer.append("\n");
    }

    //Then append to the StringBuffer again, but your StringBuffer has data saved inside :)
    for (int i = 0; i < newDataListIncoming.size(); i++) {
        auxBuffer.append(newDataListIncoming.get(i));
        auxBuffer.append(",");
        auxBuffer.append(newDatesIncoming.get(i));
        if (i != newDataListIncoming.size()-1) {
            auxBuffer.append("\n");
        }
    }
    //And write your file
    BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File("/home/mtataje/saved.txt")));       
    bw2.write(auxBuffer.toString());
    bw2.close();