for (Double d : set1) {
        boolean found = false;
        for (int i=0; i<set2.size() && !found; i++) {
                if (d.equals(set2.get(i))) {
                    found = true;
            }
        }
        if (!found) {
            set3.add(d);
        }
}