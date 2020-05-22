public class GUI { 

  static PrintQueue s = null;  

  public static void main(String[] args) {        
    s = new PrintQueue();
    ...
  }

  public PrintQueue getS() {return s;}