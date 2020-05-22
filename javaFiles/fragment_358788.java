@Stateless
public SomeServiceImpl implements SomeService
    someServiceMethod() {
       delegate.doSomething();
    }
}

public SomeServiceDelegate implements SomeService
    someServiceMethod() {
       modelObject.doSomething();
    }
}