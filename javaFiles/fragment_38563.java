public static void fillArray(String[] player ,String[] team, BufferedReader br) throws IOException{
  String line;
  int count = 0;

  while((line = br.readLine()) != null){
    player[count] = line;
    count++;
    if (count == 4) {
       count = 0;
       writeFile(player);
    }
  }