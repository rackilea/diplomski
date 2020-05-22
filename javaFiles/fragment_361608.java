class DelegatingFoo {

    Callable callMe;

    public DelegatingFoo(Callable callMe) {
        this.callMe = callMe;
    }

    public void fighters(){
          calLMe.call();
    }

};