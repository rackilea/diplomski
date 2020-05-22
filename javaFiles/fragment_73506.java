try{
    synchronized(f){
        Scanner s = new Scanner(f);
        System.out.println("starting");
        while(s.hasNext()){
            System.out.println(s.next().length());
        }
        System.out.println("finished");
        s.close();
    }
}catch(Exception e){e.printStackTrace();}