Object[] a = distance.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<Integer, Double>) o1).getValue()
                        .compareTo(((Map.Entry<Integer, Double>) o2).getValue());
            }
        });