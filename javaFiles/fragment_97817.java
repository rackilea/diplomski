132     public static <T extends Comparable<? super T>> void sort(List<T> list) {
133         Object[] a = list.toArray();
134         Arrays.sort(a);
135         ListIterator<T> i = list.listIterator();
136         for (int j=0; j<a.length; j++) {
137             i.next();
138             i.set((T)a[j]);
139         }
140     }