boolean save(){
     Caller caller = new Caller();
    caller = setCommonProperties(caller);
    caller.setCallerPropertyA(...);
    caller.setCallerPropertyB(...);

    ...

    //save caller
return true or false;
    }