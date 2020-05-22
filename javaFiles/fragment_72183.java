List<String[]> nameL = Arrays.asList(sa1, sa2, sa3);
    Collections.sort(nameL, (o1, o2) -> {
        if (o1[0].equals(o2[0])) {
            if (o1[1].equals(o2[1])) {

                return o1[2].compareTo(o2[2]);

            } else {
                return o1[1].compareTo(o2[1]);
            }
        } else {
            return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
        }
    });
    for (String[] strings : nameL) {
        System.out.println(Arrays.toString(strings));
    }