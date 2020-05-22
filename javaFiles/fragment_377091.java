public static void readFile(){
    try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
      String tmp;
      while((tmp = reader.readLine())!= null){
        fbUsers.add(tmp);
        System.out.println(tmp);
      }
    } catch (IOException e){
      e.printStackTrace();
    }
  }