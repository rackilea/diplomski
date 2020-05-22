public class FirstAndLast {
  private String message;

  public FirstAndLast(String message) {
    this.message=message;
  }

  public char getFirst(){
    return message.charAt(0);
  }

  public char getLast(){
    int len=message.length();
    return message.charAt(len-1);
  }

  public static void main(String[] args) {
    FirstAndLast fl=new FirstAndLast("Here you go");
    System.out.println("First Char is "+fl.getFirst());
    System.out.println("First Char is "+fl.getLast());
  }
}