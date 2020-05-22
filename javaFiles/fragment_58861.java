public class NestedClass05 {
     int num=1;

     public static class Test1{
          int num=2;

          public int Method1(NestedClass05 instance, int a){
              return instance.num + a;
          }
      }
  }