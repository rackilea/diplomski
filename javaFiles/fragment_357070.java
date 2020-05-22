public static void main(String[] args) {

    int i = 1;
    int limit = 10;

    while( i <limit)
    {
        if(i % 2==0)
        {
        System.out.println("i = " + i);
        }
    i++;  // put i++ inside while loop and outside of if
    }
}