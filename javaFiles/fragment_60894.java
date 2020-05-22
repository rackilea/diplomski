for (int i = 0; i < teamMatches.size(); i++) {

        Integer[] ints = teamMatches.get(i);
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == 1) homeOrAway1.add(j);
            else if (ints[j] == 2) homeOrAway2.add(j);
            else if (ints[j] == 3) homeOrAway3.add(j);
            else if (ints[j] == 4) homeOrAway4.add(j);
        }
    }