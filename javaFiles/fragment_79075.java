class A{
A(int a){

}

}

class B extends A{
B(){
super();//compile time error as no default constructor in class A
}
}