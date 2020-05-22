@Override
    protected void onPause(){
        super.onPause();
        //cancel timer to stop animations
       if(t!=null){
        t.cancel();
       }

        System.gc();
    }