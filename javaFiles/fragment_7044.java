public abstract class Feature {
    /**
      @deprecated Extend NewFeature instead and implement doSomething(a, b) 
    */
    @Deprecated
    public abstract void doSomething(String param);
}

public abstract class NewFeature extends Feature {

    @Deprecated
    @Override
    public void doSomething(String param) {
        doSomething(param, null);
    }

    public abstract void doSomething(String param, String paramTwo);
}