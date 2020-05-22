void go(){
   int x = 1;
   foo(x);
}

void foo(int y){
   int z = y;
   bar();
}

void bar(){
   Hello h = new Hello();
}