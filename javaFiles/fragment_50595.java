//DANGER - CODING HORROR!

static final sEmpty=new ArrayList<Foo>();

public ArrayList<Foo> find(Bar bar) {  
        ArrayList<Foo> foos = null;
        for (Foo f: Foo.values()) {
            if (f.someBarCollection.contains(bar)) {
                if(foos==null){
                    foos=new ArrayList<Foo>();
                }
                foos.add(f);
            }
        }
        return foos==null?sEmpty:foos;
 }