BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
do{
          String resultData = HTTP.GET <uri>;
          writer.write(resultData + "\n");
}while(resultData.exists());
writer.close();