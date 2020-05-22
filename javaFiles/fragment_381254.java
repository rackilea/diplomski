class N2 {
  public static void main(String args[])
  {
    System.out.println(check()); 
  }
  static Integer check()
  {
    return false ? 0 : fNull(); 
  }
  static Integer fNull() 
  {
    return null;
  }
}