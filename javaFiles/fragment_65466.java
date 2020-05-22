//synchronized wait block
while(myRunnable.needWait){
    myRunnable.wait();
}

//synchronized notify block
this.needWait = false;
myRunnable.notify();