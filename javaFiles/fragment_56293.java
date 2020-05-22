pool.execute(new Runnable(){
    try{
        doSomethingAndCallMeBackWhenItsDone(new Callback() {
            public void done() {
                doSomethingElse();
            }
        });
    }catch(Exception e){ throw new RunTimeException(e) } 

});