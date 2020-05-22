boolean exists = false;
for (File f : vector) {
    if (f.getName().equals("abc.xml")) {
        exists = true;
        break; // no need to continue the loop
    }
}
if (exists) {
    System.out.println("Yes..abc.xml exists");     
else {
    System.out.println("OOPS! abc.xml does not exist");
}