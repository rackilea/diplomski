public static void main (String[] args)
{  
    int start =Integer.parseInt(args[0]);
    int count =Integer.parseInt(args[1]);


    int[] prime = new int[count];
    int i = 0;
    while (i < count){
        if(check(start)){
            prime[i] = start;
            i++;
        }
        start++;
    }
    for (int p : prime){
        System.out.println( p);
    }
}