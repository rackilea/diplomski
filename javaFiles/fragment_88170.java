interface X{
public void eat();
}

interface Y{
public void drink();
}

class XYZ implements X,Y{
@Override
public void eat(){
    System.out.println("I am eating.");   
}
@Override
public void drink(){
    System.out.println("I am drinkin too!");
}    
}

class A<T extends X & Y> {
public void display(){
     XYZ x=new XYZ();
     x.eat();
     x.drink();
     System.out.println("Type of XYZ is "+x.getClass().getName());
    }  
}

public class Sample1{
public static void main(String[] args) {
 A<XYZ> a=new A<>();
 a.display();
}    
}