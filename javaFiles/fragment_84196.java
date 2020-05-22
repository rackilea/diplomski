public static void main(String[] args){

        List<Object[]> list = new ArrayList<Object[]>();
        Object[] object1 = { 2, 3 };
        Object[] object2 = { 5, 8 };
        list.add(object1);
        list.add(object2);
        System.out.println(list.toString()); // prints address here

        for (Object[] myArray : list) {
            for (Object obj : myArray) {
                System.out.println(obj); // print elements
            }
        }
    }