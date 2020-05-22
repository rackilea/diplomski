public static void main(String[] args) {
    String regex = "^((\\d{10}|\\d{16})[,;])*(\\d{10}|\\d{16})$";
    String y = "0123456789,0123456789123456,0123456789";
    System.out.println(y.matches(regex)); //Should be true
    String n = "0123456789,01234567891234567,0123456789";
    System.out.println(n.matches(regex)); //should be false
  }