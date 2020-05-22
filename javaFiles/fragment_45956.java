public void run() {
 while(true){
    synchronized(alarmzeiten){
        for(int i = 0; i < alarmzeiten.length; i++){ 
            System.out.println(alarmzeiten[i]);
         }
    }
}