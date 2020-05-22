package map;

    Map<Integer,ListLabcar> ma = new LinkedHashMap<Integer,ListLabcar>();
    for(int l =0;l<5;l++){
        ListLabcar lc = new ListLabcar();
        int j = 0;
        for(int i = 0;i<=3;i++){
            if(i==l){
                System.out.println("ok");
                j+=1;
                lc.setIn(j);
                lc.setS("a-"+l);break;
            }
            else{
                lc.setIn(l);
                lc.setS("zero-"+l);
                //break;
            }
        }
        ma.put(l, lc);
        System.out.println(ma.get(l).getIn());
        System.out.println(ma.get(l).getS());
    }
    System.out.println(ma.size());
    Set<Integer> ke = ma.keySet();
    for(Integer k:ke){
        System.out.println(k);
        System.out.println("int--->"+ma.get(k).getIn());
        System.out.println("sttr--->"+ma.get(k).getS());
    }
}