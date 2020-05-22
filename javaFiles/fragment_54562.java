public static void main(String[] args)
{

    String urlarr[] = new String[MAX_SERVER];
    init(urlarr);

    int idx = 0;
    while(idx < 1000){
        String next = urlarr[idx++%urlarr.length];
        System.out.println(next);
    }
}

private static void init(String[] urlarr)
{
    for(int i=0 ; i<urlarr.length ; i++){
        urlarr[i] = "url("+i+")";
    }

}