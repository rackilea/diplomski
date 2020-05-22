TreeMap<Integer,Integer> tree=new TreeMap<>();          
        tree.put(1,5);
        tree.put(2,6);
        tree.put(3,4);
        tree.put(4,4);   

        Entry<Integer,Integer> entry=tree.firstEntry();
        int c=0;
        while(tree.higherEntry(entry.getKey())!=null) {
            if(entry.getValue()>tree.higherEntry(entry.getKey()).getValue())
                c++;
            entry=tree.higherEntry(entry.getKey());
        }