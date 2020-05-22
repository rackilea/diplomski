void change (MyClass x,y) {
    MyClass temporary= new MyClass();
    temporary.copyFrom(x);
    x.copyFrom(y);
    y.copyTo(temporary);
}