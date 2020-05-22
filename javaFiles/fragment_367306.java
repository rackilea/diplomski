public static void main(String[] args) {
    try{
      File file = new File("path\\to\\yourfile");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = "";
      String nationalities = "";
      String phones = "";
      while((line = br.readLine()) != null){
        String[] s = line.split("'");
        if(s.length > 0){
          if(s[1].matches("[a-zA-Z]+")){
          // nationalities
          nationalities += (nationalities.isEmpty()) ? s[1] : " " + s[1];
          }else{
          // line with phone numbers
          phones += (phones.isEmpty()) ? s[1] : " " + s[1];
          }
        }
      }
      String[] nationArr = nationalities.split(" ");
      String[] phoneArr = phones.split(" ");
      for(String val : nationArr){
        System.out.println(val);
      }
      System.out.println("------------");
      for(String val : phoneArr){
        System.out.println(val);
      }
    }catch(IOException e){
      System.out.println("Error");
    }

  }