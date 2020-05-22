public static void main(String args[]) {
    Plane pl = new Plane() {
       @Override
       public void fly() {
           System.out.println("The plane is flying...");
       }
    };

    pl.fly();
}