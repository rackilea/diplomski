Object[] A = //{o1, o2, o3, o4, ... on};
Object[] B = //{p1, p2, p3, p4, ... pm};
HashMap<Object, Integer> oMap = new HashMap<Object, Integer>();
HashMap<Object, Integer> pMap = new HashMap<Object, Integer>();

for(int i = 0 ; i < A.length ; i++) {
    Object o = A[i];
    oMap.add(o, i);
}

for(int i = 0 ; i < B.length ; i++) {
    Object p = B[i];
    pMap.add(p, i);
}