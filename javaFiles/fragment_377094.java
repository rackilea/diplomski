private static final String fileName = "fbusers.txt";
private static final List<String> fbUsers = new ArrayList<>();

public static void main(String[] args){
    readFile();
    login(fbUsers.get(0));
    writeFile();
  }