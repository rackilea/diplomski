private static void doSomething(Object obj2) {
    if (obj2 instanceof Simple) {
        Simple simple = (Simple) obj2;  
        simple.a = 99;
        simple.name = "new name";
    }
}