obj1 = checkAndClean(obj1);
obj2 = checkAndClean(obj2);

public Object checkAndClean(Object obj) {
    if(obj != null) {
        obj.clean();
    }
    return null;
}