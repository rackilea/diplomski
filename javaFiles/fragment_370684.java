public class Test{
  public static void main(String[] a){ 
    String preBody = "The AThe CThe IThe O";
    String[] parts = preBody.split("(?=The)");
    for (String s : parts){
      if( null != s && !"".equals(s)){
        System.out.println(">> " +s );
      }   
    }   

  }

}