List<Object[]> list = new ArrayList<>();
    list.add(new Object[] { "cat", (long) 1422355945 });
    list.add(new Object[] { "dog", (long) 1422355970 });
    list.add(new Object[] { "rat", (long) 1422355900 });

    Collections.sort(list, new Comparator<Object[]>() {
        @Override
        public int compare(Object[] o1, Object[] o2) {
            int cmp1 = ((String) o1[0]).compareTo((String) o2[0]);
            if (cmp1 == 0) {
                return Long.compare((Long) o1[1], (Long) o2[1]);
            }
            return cmp1;
        }
    });