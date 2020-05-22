void Method1(){
    //can run in parallel 
    synchronized(this){
        //cannot run in parallel.
    }
    //can run in parallel.
}
void Method2(){ 
    synchronized(this){
        //cannot run in parallel.
    }
}