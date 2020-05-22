public static void main(String[] args){
    Runnable r = ()->{
        try{
            Thread.sleep(500);
            System.out.println("ran!");
        } catch(Exception e){ return;}
    }
    r.run();
    System.out.println("finishing main.");
}