RealmResults<Leaderboard> leaderboardList = realm.where(Leaderboard.class).distinct("score").findAll();
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < leaderboardList.size(); i++) {
            strings.add(leaderboardList.get(i).getScore());
        }

        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                BigInteger bi1 = new BigInteger(o1);
                BigInteger bi2 = new BigInteger(o2);
                return bi2.compareTo(bi1);
            }
        });