public class MP3 {
  public void play(final InputStream in) {
     new Thread() {
        @Override
        public void run() {
           try {
              new Player(in).play();
           } catch (Exception e) {
              System.err.println(e.getMessage());
           }
        }
     }.start();
   }
 } 

private HashMap<String, URL> soundMap = new HashMap<String, URL>();

public void loadSounds() {
      String[] filenames = {
         "5_seconds_remaining.mp3",
         "10_seconds_remaining.mp3",
         "button_press_loud.mp3"
      };
      for (String s : filenames) {
         soundMap.put(s.substring(0, s.indexOf('.')), getClass().getResource("sounds/" + s));
      }
   }

public void playSound(String name) {
     try {
         new MP3().play(new BufferedInputStream(soundMap.get(name).openStream()));
     } catch (IOException ex) {}
}