class EuropeanRouletteGame{
    static int number;
    static final int range = 37;
    static void newNumber(){
        number = (int)(Math.random() * ranage);
    }
    static int getNumber(){
        return number;
    }
}