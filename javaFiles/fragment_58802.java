ArrayList<Integer> getList(int[] a)
    {
        List<Integer> l = new ArrayList<Integer>();

        for(int i : a)
            l.add( new Integer(i) );

        return l;
    }