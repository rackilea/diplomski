public class splitstring {
 public static void main(String[] args){
  String tosplit, part1, part2 = new String();
  int ind = 0;
  tosplit = "push1234";
  ind = tosplit.indexOf("push");
  part1 = tosplit.substring(ind,ind + 4);
  part2 = tosplit.substring(ind + 4, tosplit.length());
 }
}