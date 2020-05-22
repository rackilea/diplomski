public class Match {
  public static void main(String[] args) {
    Pattern p = Pattern.compile("aa");
    StringBuffer buffy = new StringBuffer(200);
    int count = 0;
    for(int i = 0; i < 200; i++){
      buffy.append("a")
      if (p.matcher(buffy.toString()).matches()){
        count++;
      }
    }
    System.out.println(count);
  }
}