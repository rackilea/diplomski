class A{
int a = 10;
public static void main(String args[]){
A a = new A();
A b = new A();
b.a += 10;
System.out.println(a.a);
System.out.println(b.a);
}
}