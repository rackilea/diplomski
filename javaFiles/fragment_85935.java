Object a = new Object();
Object b = new Object();
...
synchronized(a){
    doStuff();
}
...
synchronized(b){
    doSomeStuff();
}
...
synchronized(a){
    doOtherStuff();
}