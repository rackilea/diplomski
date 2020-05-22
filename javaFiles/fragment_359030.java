public static void main(String[] args) {
        Moving moving = new Moving();
        moving.forward();
        moving.forward();
        System.out.println(moving.move.y); //prints 10;
        moving.status.setStatus(moving.move);
        moving.status(); //prints 0; I need it to print 10 too;
 }