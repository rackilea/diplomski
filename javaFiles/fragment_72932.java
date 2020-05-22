private char instanceVariable;

public void someMethod (char someLocalParameter) {
    /* local means that it is only known inside this method. That's why everything 
     *  you assign to it just disappears after executing the method.
     */   

     someLocalParameter = this.instanceVariable // nothing happens

     this.instanceVariable = someLocalParameter // will do the job
}