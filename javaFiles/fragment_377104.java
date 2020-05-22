public static void play(String name) {
   try{
     AudioInputStream sounds = AudioSystem.getAudioInputStream(Buzzer.class.getResource(name));
     final Clip clip = AudioSystem.getClip();
     clip.addLineListener(new LineListener() {
         public void update(LineEvent e) {
             LineEvent.Type type = e.getType();
             if(type == type.STOP) clip.close();
         }
     });
     clip.open(sounds);
     clip.start();
   } catch(Exception e){
       e.printStackTrace();
   }