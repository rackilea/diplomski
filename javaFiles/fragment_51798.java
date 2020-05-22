List<Integer> homework = new ArrayList<>();
    homework.add(new Integer(6));
    homework.add(new Integer(7));
    homework.add(new Integer(8));
    homework.add(new Integer(9));

    for (Integer integer : homework) {
        System.out.println(integer);
    }

    for (Iterator<Integer> it = homework.iterator(); it.hasNext();) {
        Integer integer = it.next();
        System.out.println(integer);

    }

    for (int i = 0; i < homework.size(); i++) {
        Integer integer = homework.get(i);
        System.out.println(integer);

    }