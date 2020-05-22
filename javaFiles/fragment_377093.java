public static void writeFile(){
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
      for(String fbUser : fbUsers){
        writer.write(fbUser);
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }