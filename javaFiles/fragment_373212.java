class SynchronizedNumberFormat extends NumberFormat {

    public synchronized String format(Number number) {
        return super.format(number);
    }

    //unimplemented methods...

}