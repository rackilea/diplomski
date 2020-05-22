class Ab {
    int i = 10; 
    void getF() {
        System.out.println("I am good");
    }
}
class Main extends Ab {
    int i = 10; 
    @Override
    void getF() {
        System.out.println("I am good and bad boy");
    }
    public static void main(String[] args) {
         //Hamm h = new Hamm();      
        // h.getF(); //Ham
        Ab a = new Main();  //reference of parent class
        a.getF(); // Ab class

    }
}