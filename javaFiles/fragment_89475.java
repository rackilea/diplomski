if(scan.hasNextInt()) {
    coin1.setValue(scan.nextInt());
} else {
    System.out.println("C'mon, you need to enter an int!");
    sc.next(); // clear their garbage response
}