BufferedWriter writer = new BufferedWriter(new FileWriter(path, true), 8192 * 4);
do{
          String resultData = HTTP.GET <uri>;
          writer.write(resultData + "\n");
}while(resultData.exists());
writer.close();