package example;

import javax.xml.bind.JAXBContext;
import example.foo.Foo;
import example.bar.Bar;

public class Demo {

    public static void main(String[] args) throws Exception{
        System.out.println(JAXBContext.newInstance(Foo.class).getClass());
        System.out.println(JAXBContext.newInstance(Bar.class).getClass());
        System.out.println(JAXBContext.newInstance(Foo.class, Bar.class).getClass());
    }

}