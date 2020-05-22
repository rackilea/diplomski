if(methodName.equalsIgnoreCase("sampleTest1")){
    method[i].setAccessible(true);
    System.out.println(method[i].invoke(s, (Object) null));
} else{
    method[i].setAccessible(true);
    System.out.println(method[i].invoke(s, null));
}