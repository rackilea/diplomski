public static int itFunc(int m, int n){
    Stack<Integer> s = new Stack<Integer>;
    s.add(m);
    while(!s.isEmpty()){
        m=s.pop();
        if(m==0||n==0)
            n+=m+1;
        else{
            s.add(--m);
            s.add(++m);
            n--;
        }
    }
    return n;
}