private static void innerLoop(int i, int j){
    while(j-->=0) {
        System.out.println(j);
    }
}

public static void main (String[] args) throws java.lang.Exception
{
    for(int i=1,j=3;i<3;innerLoop(i++,j));
}