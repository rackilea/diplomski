Collections.sort(list,
        new Comparator<T>()
        {
            public int compare(T f1, T f2)
            {
                return f1.toString().compareTo(f2.toString());
            }
        });