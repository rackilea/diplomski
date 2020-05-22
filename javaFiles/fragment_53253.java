package org.brooth.jeta.samples;

public class SayHelloApp {

    @Hello
    String text;

    public SayHelloApp() {
      MetaHelper.setHello(this);
    }

    public void sayHello() {
      System.out.print(text);
    }

    public static void main(String[] args) {
      new SayHelloApp().sayHello();
    }
}