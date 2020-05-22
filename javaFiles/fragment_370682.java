public class Test{
  public static void main(String[] s){ 
    int bodyCnt = 5;
    int cnt = 0;
    String eachBody;
    String preBody = "The AThe CThe IThe O";
    int extra = 0;
    int limit = preBody.length();
    while(limit >= bodyCnt){
      eachBody = preBody.substring((cnt+extra), (bodyCnt+cnt));
      cnt = cnt + eachBody.length();
      extra = 0;
      limit = limit - eachBody.length();
      System.out.println("eachBody : -----"+eachBody);
    }   
  }

}