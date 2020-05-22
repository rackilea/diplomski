pool.execute(new Runnable(){
    try{
        doSomethingAndCallMeBackWhenItIsDone(new Callback() {
            public void done() {
                pool.submit(new Callbale<Void>() {
                    public Void call() {
                        doSomethingElse();
                    }
                }
            }
        });
    }catch(Exception e){ throw new RunTimeException(e) } 

});