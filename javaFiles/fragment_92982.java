...
int[] id; // more common to write int[] instead of id[]
int[] pr;
...
public Obj(int a[], int b[], int l){
    int i;
    len = l;
    pr = new int[len];
    id = new int[len];
    for(i=0;i<len;i++){
        id[i] = a[i];
    }
    for(i=0;i<len;i++){
        pr[i] = b[i];
    }
}