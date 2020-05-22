private void incrementAndReport() {
    try {
        System.out.println(count.incrementAndGet() + "here"); //does not print
    }
    catch (Exception exc) {
        System.out.println (exc);
    }
}