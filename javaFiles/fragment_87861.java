for (int c = 0; c < eList.size(); c++) {
        P p = map.get(eList.get(c).path);
        if ( p != null ) {
            Pair rank = new Pair();
            rank.k = z + c / 2.0;
            rank.path = p.path;
            pcList.add(rank);
        }
    }