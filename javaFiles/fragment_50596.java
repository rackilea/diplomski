public ArrayList<Foo> find(Bar bar) {  
        if(bar==null){
            throw new IllegalArgumentException("bar==null");
        }
        ArrayList<Foo> foos = new ArrayList<Foo>();
        for (Foo f: Foo.values()) {
            if (f.someBarCollection.contains(bar)) {
                foos.add(f);
            }
        }
        return foos;
 }