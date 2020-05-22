try{
    // some code that could throw  MyException;
 }
 catch (MyException e){
     // this will be called when MyException has occured
 }
 catch (Exception e){
     // this will be called if another exception has occured
     // NOT for MyException, because that is already handled above
 }
 finally{
     // this will always be called,
     // if there has been an exception or not
     // if there was an exception, it is called after the catch block
 }