int z = 0;
while(z != q.length) {
    int x = (int) (Math.random() * 10);
    boolean isDup=false;
    for (int i=0;i<z&&!isDup;i++) {
        if (x==q[i])
            isDup=true;
    }
    if (!isDup) {
        q[z] = x;
        System.out.println(q[z]);                           
        z++;                       
    }
}