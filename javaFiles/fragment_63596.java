public static int method(int value, List<Integer> list){
    for (int j = 0; j < list.size(); j++) {
        Integer i = list.get(j);
        if (i == value){
            return j;
        }
    }
    throw new IllegalStateException("The method 'SomeClass.method' reach an invalid termination point");
}