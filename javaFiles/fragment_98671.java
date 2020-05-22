public void doWait(Object o) {
    o.wait(); // you would like the compiler to flag this
}

// but in this case it is valid
synchronized(this)
{
    doWait(this);
}