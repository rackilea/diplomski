for (String x : hash.keySet()) {
        long neu = hash.get(x);
        for (String s : words) {
            if (x.equals(s)) {
                neuS.add(x);
                neuZ.add(neu);
                disc = disc + 1;
            }
        }
    }