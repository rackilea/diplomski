String[] arr = new String[8];
boolean found = false;
for(String s : arr) {
    if(s.equalsIgnoreCase("example")) {
        found = true;
        break;
    }
}
if(found) {
    // Do this
} else {
    // Do that
}