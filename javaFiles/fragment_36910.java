try {
    // Do something
} catch (Exception ohNo) {
    System.out.printf("Caught exception %s doing something.%n", ohNo.toString());
    ohNo.printStackTrace();
}