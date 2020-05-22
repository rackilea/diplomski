public static void main(String args[]){

        List<MediaPlayer> mp=new ArrayList<>();
        List<MediaPlayer> remove=new ArrayList<>();//I have made this for demostration purpose that you could even collect these objects somewhere and do something with them!

        mp.add(new MediaPlayer("web","Video",1320));
        mp.add(new MediaPlayer("web","Play",1320));
        mp.add(new MediaPlayer("web","Download",1320));
        mp.add(new MediaPlayer("web","Play",1321));

        mp.forEach((it)->{
            System.out.println("Event: "+it.getEvent()+" Action: "+it.getAction()+" TimeStamp: "+it.getTimeStamp());
        });

       Iterator<MediaPlayer> iter = mp.iterator();
       Iterator<MediaPlayer> iter1 = mp.iterator();
       for(MediaPlayer it:mp){
           for(MediaPlayer itr:mp){
               if(it.getAction().equals("Download") && it.getTimeStamp()==itr.getTimeStamp() && itr.getAction().equals("Play")){
                   remove.add(itr);// I add the objects to be removed in remove list first. This way I will even have the list of deleted objects
               }
           }
       }
       mp.removeAll(remove);//Then finally I remove them from main list

       System.out.println("\n");
        mp.forEach((it)->{
            System.out.println("Event: "+it.getEvent()+" Action: "+it.getAction()+" TimeStamp: "+it.getTimeStamp());
        });
}