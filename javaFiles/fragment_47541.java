abstract class ConsumerBase {
    public void authenticate(MyUserPassBean bean) {
        try {
            authenticate(bean.username, bean.password);
        } catch (Exception e) {
            throw new MyException();
        }
        //...
    }

    protected abstract boolean authenticate(String username, String password);
}

class SomeGivenServiceConsumer extends ConsumerBase {

    SomeGivenService a;

    public SomeGivenServiceConsumer(SomeGivenService a) {
        this.a = a;
    }

    @Override
    protected boolean authenticate(String username, String password) {
        return a.authenticate(username, password);
    }
}

class AnotherGivenServiceConsumer extends ConsumerBase {

    AnotherGivenService a;

    public AnotherGivenServiceConsumer(AnotherGivenService a) {
        this.a = a;
    }

    @Override
    protected boolean authenticate(String username, String password) {
        return a.authenticate(username, password);
    }
}