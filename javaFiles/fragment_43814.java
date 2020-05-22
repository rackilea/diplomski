class Worker {  
    public Integer somework(){  
        Integer k=0;  
        Helper h= createHelper();  
        h.change(k);  
        return k;  
    }

    // this method may be mocked when testing somework, to return a mock helper.
    protected Helper createHelper() {
        return new Helper();
    }
}