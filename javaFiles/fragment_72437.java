Object x = ...; // get it from somewhere
try {
x.getClass().getDeclaredField("as").get(x);
} catch(Exception ex) {
 //do error handling here
}