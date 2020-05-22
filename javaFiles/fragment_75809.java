public static void callVoidMethod(Set<Integer> set) {

    Set<Integer> superset = new HashSet<Integer>();
    ...
    if (conditionSatisfied) superset.add(someValue);

    ...
    if(set.contains(value) || superset.contains(value))
        doSomething();

}