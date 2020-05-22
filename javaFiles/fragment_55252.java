public class test{
  public static void main(String[] args){
    String[] splitWords = {"to", "in", "from", "then"};
    String str = "this from that";
    String[] tmp;
    for (String splitTkn : splitWords){
      tmp = str.split(splitTkn);
      if (tmp.length > 1){
        System.out.println(tmp[0].trim());
        System.out.println(tmp[1].trim());
      }
    }
  }
}