try{
    //...
} catch (MutationsRejectedException e) {
    Throwable c = e.getCause();
    if(c instanceof MyException){
        //...
    }else{
        throw e;
    }
}