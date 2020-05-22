public static <T> void merge(ArrayList<T> array, Comparator<T> c, int p, int mid, int q) {
        ArrayList<T> tmp = new ArrayList<T>(q-p+1); 
        int i = p;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= q) {
            if (c.compare(array.get(i), array.get(j))<0)

                tmp.add(array.get(i++));
            else
                tmp.add(array.get(j++));
            k++;
        }
        if (i <= mid && j > q) {
            while (i <= mid) 
                tmp.add(array.get(i++));
        } else {
            while (j <= q)
                tmp.add(array.get(j++));
        }
        for (k = 0; k < tmp.size(); k++)
          array.set(k, tmp.get(k));

        System.out.println(array);
      }