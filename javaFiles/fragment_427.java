List<Integer> list1 = new ArrayList<>(Arrays.asList(1099,9872,3453));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4765,9875,6564));
        List<Integer> list3 = new ArrayList<>();
        list3.addAll(list1);
        list3.addAll(list2);
        System.out.println(list3.get(0)==list1.get(0));