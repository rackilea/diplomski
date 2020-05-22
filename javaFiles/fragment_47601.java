System.out.println("sort by score ascending");
    data.sort(new Comparator<NameScoreEntity>() {
        @Override
        public int compare(NameScoreEntity o1, NameScoreEntity o2) {
            return Integer.compare(o1.score, o2.score); //for descending just swap o1 & o2
        }
    });
    for (NameScoreEntity e : data) {
        System.out.println(e);
    }

    System.out.println("sort by Name ascending");
    data.sort(new Comparator<NameScoreEntity>() {
        @Override
        public int compare(NameScoreEntity o1, NameScoreEntity o2) {
            return o1.name.compareTo(o2.name) ;//for descending just swap o1 & o2
        }
    });
    for (NameScoreEntity e : data) {
        System.out.println(e);
    }