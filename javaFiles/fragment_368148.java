public ArrayList<Integer> getAllPropertyValues(ToIntFunction<SomeObjectClass> function) { 
    ArrayList<Integer> temp = new ArrayList<>();
    for (someObject x : someObjectList) {
        temp.add(function.apply(x));
    }
 }