public interface MyFoo {
    void run();
}

public void setMyFoo(MyFoo foo) {
   mMyFoo = foo;
}

//time to call their code
mMyFoo.run();