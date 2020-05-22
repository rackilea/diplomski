public class substr {
  public static void main(String[] args) {
    recsub("abcd", 0, 1);
  }

  public static void recsub(String str, int start_pos, int size){
    if (size > str.length()) {
      // Print newline; restart with next character
      System.out.println();
      recsub(str, ++start_pos, start_pos+1);
    }
    else {
      // Print one substring
      System.out.print(str.substring(start_pos, size)+" ");
      if (start_pos+1 < str.length()) {
        recsub(str, start_pos, size+1);
      }
    }
  }
}