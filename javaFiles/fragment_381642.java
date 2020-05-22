class ApiWrapper<K, T extends base<K>>{

    private T t;

    public ApiWrapper(T t){
        this.t = t;
    }

    public void wrap(){
        init(t)
    }

    private void init(T t){
        t.method1("hello");
        K k = t.method2("world");
    }
}


ApiWrapper<Object, Api1> apiWrapper1 = new ApiWrapper<>(new Api1());