<T1, T2> void someMethod(Collection<T1> collection, Class<T2> type) {
        List<T2> sublist = new ArrayList<T2>();

        for (T1 i : collection) {
            if (type.isAssignableFrom(i.getClass())) {
                sublist.add((T2) i);
            }
        }


    }