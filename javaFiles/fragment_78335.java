public class Foo {
     public synchronized StringBuilder sb = ...;
     public void doSomething1(){
         StringBuilder sb = this.sb;
         sb.append("foo");
     }

     public void doSomething2(){
         this.sb.append("foo");
     }
}