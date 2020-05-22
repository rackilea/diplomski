interface IExample {
    methodA();
    methodB();
    methodC();
    ...
    methodN();

    execute();
}

class A implements IExample {
    //...
    execute() {
        methodA();
        methodC();
    }
}

...

commands.get("key1").execute();