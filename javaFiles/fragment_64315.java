try {
    // do stuff
} catch (RuntimeException e) {
    throw e;
} catch (Exception e) {
    e.printStackTrace(); // or other approptiate action, i.e. log it.
}