public static SQL getOrMakeInstance1() {
    if(instance1 == null) {
        instance1 = new SQL(pram11,param12,param13);
    }
    return instance1;
}


public static SQL getOrMakeInstance2() {
    if(instance2 == null) {
        instance2 = new SQL(pram21,param22,param23);
    }
    return instance2;
}