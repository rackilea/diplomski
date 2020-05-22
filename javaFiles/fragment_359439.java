class Example {

  private static int[] outside = new int[]{1};

  public static void main(String [] args){
    final int[] inside = new int[]{2};

    Object inner = new Object(){{
      System.out.println(outside[0]);
      System.out.println(inside[0]);
    }};
   }
  }