public static <T> void swap(List<T> list, int i,
            int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }