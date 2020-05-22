process (Exception e){ //If the exceptions extend a common specific type, use it here
    if(e instanceof MyExceptionType1)
       process((MyExceptionType1) e);
    else if (e instanceof MyExceptionType2)
       process((MyExceptionType2) e);
}