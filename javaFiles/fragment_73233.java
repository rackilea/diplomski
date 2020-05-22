final List<String[]> tmpList = new ArrayList<>();
    for (String[][] t : flight) {
        if (t == null) {
            continue;
        }
        for (String[] k : t) {
            if (k == null || k.length < 1 || k[0] == null) {
                continue;
            }
            for (String day : k[0].split(",")) {
                String[] tmp = Arrays.copyOf(k, k.length);
                tmp[0] = day;
                tmpList.add(tmp);
            }
        }
    }
    String[][] flight_of_day = tmpList.toArray(new String[tmpList.size()][]);