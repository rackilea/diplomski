List<Integer> first_list = new ArrayList<Integer>();

        first_list.add(10);
        first_list.add(20);
        first_list.add(30);

        List<Integer> second_list = new ArrayList<Integer>();
        second_list.add(40);
        second_list.add(20);
        second_list.add(30);

       List<Integer> third_list = new ArrayList<Integer>(second_list);
third_list.retainAll(first_list);

        for (int i = 0; i < third_list.size(); i++) {
            System.out.println("===>" + third_list.get(i));
        }