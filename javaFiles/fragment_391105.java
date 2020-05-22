Integer obj1 = 1;
Double obj2 = 2.0;

obj1 = checkAndClean(obj1);
obj2 = checkAndClean(obj2);
System.out.println("" + obj1 + ", " + obj2);

public <T extends Number> T checkAndClean(T obj) {
    if(obj != null) {
        obj.intValue(); // your cleanup method
    }
    return null;
}