class A<T>{
    T value;
    B<? super T> b;
    void method(){
        b.method(value);
    }
}
interface B<X>{
    <VT extends X> VT method(VT p);
}
// works fine
class C implements B<Number>{
    public <VT extends Number> VT method(VT p){return p;}
}
// causes warning
class D implements B<String>{
    public <VT extends String> VT method(VT p){return p;}
}