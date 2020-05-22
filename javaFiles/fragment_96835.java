public static void main(String[] args) { //main method
    int angles = 15;
    double  cosines =4;
    int meters =15;
    for (int i =1; i<=78;i++){
        System.out.print(i);
        System.out.print('|');
        System.out.print(angles);
        angles+=5;
        if (angles>75){
            angles=15;
        }
        System.out.print('|');
        System.out.print(meters);
        meters+=3;
        if (meters>30){
            meters=15;
        }
        System.out.println("|4|");
    }

}