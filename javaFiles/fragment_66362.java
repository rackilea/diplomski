while((currentData=bufferedReader.readLine()) != null) {
            line = currentData;
            bw.write(currentData);
            ((BufferedWriter) bw).newLine();
    }
    bw.write(Details);