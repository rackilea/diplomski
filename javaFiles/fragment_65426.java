public static void main(String[] args) { 
    for(int i = 1; i < 100; i++) { //notice i++ instead of i+=6
        if(i % 10 == 0) {
            System.out.println(); //this happens every 10th iteration
        }
        System.out.print(i*6 + " "); //multiple of 6
    }
}