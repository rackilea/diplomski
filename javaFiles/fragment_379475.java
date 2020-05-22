public static void main(String[] args) {
    int x=0;
    int t1 = ++x;
    System.out.println(t1);//t1 = 1 and x = 1
    int t2 = x++;
    System.out.println(t2);//t2 = 1 and x = 2
    int t3 = x++;
    System.out.println(t3);//t3 = 2 and x = 3
    int t4 = ++x;
    System.out.println(t4);//t4 = 4 and x = 4

    x= t1 + t2 + t3 + t4;//x = 1 + 1 + 2 + 4
    System.out.println(x);//8
}