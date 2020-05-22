int max = 10000;
int row = 10;
boolean[] seen=new boolean[max+1];
for(int i=2;i<=max;i+=2) seen[i]=true;
int w = 0;
for(int i=2;i<=(row);i++) {
    int self_count = 0;
    for(int j=(2*i-1);j<=max;j+=(2*i-1)) {
        self_count++;
        if(seen[j]) w++; else seen[j]=true;
    }
    w += self_count/2;
    System.out.println("w"+(i-1)+": "+w);
}