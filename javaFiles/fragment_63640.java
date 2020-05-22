Scanner s = new Scanner(new File("test.txt"));
        String str = "";
        List<List<String>> list = new ArrayList<List<String>>();

        while (s.hasNext()) {
            list.add(Arrays.asList(s.nextLine().split(",")));
        }

        // then you can acces random element from the list this way
        System.out.println(list.get(0).get(1));

        // or print all values in the list
        for (List<String> elem : list) {
            System.out.println(Arrays.toString(elem.toArray()));
        }