boolean started = false;

while(something){
    if(!started){
        thread.start();
        started = true;
    }
}