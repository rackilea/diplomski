if (runway1available) {
    synchronized(runway1) {
        runway1available=false;
        landonrunway1()
        runway1available=true;
    }
}
else if (runway2available) {
   // ...
}