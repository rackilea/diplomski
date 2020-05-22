public static void main(String[] args){
    Runnable r = ()->{
        try{
            Thread.sleep(500);
            System.out.println("ran!");
        } catch(Exception e){ return;}
    }
    new Thread(r).start();
    System.out.println("finishing main.");
}