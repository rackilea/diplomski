public static List<Integer> myList = new ArrayList<Integer>();

public static List<? extends Number> getList() {
    return myList;
}

public static void main() {
    getList().add(Integer.valueOf(1000)); // Can not substitute wildcard by Integer 
}