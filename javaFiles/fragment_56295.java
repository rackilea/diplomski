pool.execute(new Runnable(){
    try{
        doSomethingAndCallMeBackWhenItsDone(new Callback() {
            public void done() {
                doSomethingElse();
            }
            public void timeout() {
                //opps!
            }
        });
    }catch(Exception e){ throw new RunTimeException(e) } 

});