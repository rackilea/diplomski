public static void main(String[] args){
    Robot bot = new Robot(); // if Robot constructor declared AWTException
                             // the class instance initialization line should
                             // be wrapped in the try-catch block as well
    try{
        bot.mouseMove(50, 50);//mouseMove might throw AWTException
    }catch( AWTException awte){
        System.err.println("Exception thrown:" + awte.getMessage());
    }
}