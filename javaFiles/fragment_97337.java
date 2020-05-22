enum Operation {

  PLUS {
      public double calc(double x, double y) {
          return x + y;
      }
  },
  MINUS {
      public double calc(double x, double y) {
          return x - y;
      }
  },
  MULTILPLE {
      public double calc(double x, double y) {
          return x * y;
      }
  },
  DIVIDED_BY {
      public double calc(double x, double y) {
          return x / y;
      }
  };

  **public abstract double calc(double x, double y);**

  public static void main(String args[]) {
      double x = 15.25;
      double y = 24.50;
      for (Operation oprt : Operation.values()) {
          System.out.println(x + " " + oprt + " " 
                  + y + " = " + oprt.calc(x, y));
      }
  }
}