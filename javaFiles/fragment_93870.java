//B.java

package b;

public class B{

  String s;

  public B(String s){

   this.s = s;

  }

  public void run(){
    System.out.println(s);
  }
}


//A.java

package p;

import b.B;

class A{

  public static void main(String[] args){

B b = new B("haha");

b.run();

  }

}