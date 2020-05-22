public void writeToDataBase(final Object toWrite) {
    executor.submit(new Runnable() {
        public void run() {
             writeToDBNow(toWrite);
        }
    });
    // if toWrite were mutable and you changed it now, what would happen !?
}
// after the method returns toWrite no longer exists for the this thread...