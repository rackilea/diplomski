class SearchClass {
   public static void main(String[] args) {
      MusicArray musicArray = new MusicArray();
      musicArray.addMusic(new Music("Foobars Unit", 10.4, 5));
      musicArray.addMusic(new Music("Spamalot", 11.0, 7));
      //... etc ...

      musicArray.printOutSongDetails();
   }
}