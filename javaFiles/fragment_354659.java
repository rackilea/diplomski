public class Main {

public void after(JoinPoint point,Throwable ex){
    System.out.println(point);
    System.out.println("catch error:"+ex.getMessage());
}