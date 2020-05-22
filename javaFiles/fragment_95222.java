@Override
       public void startPlay(Stage stage) throws Exception {
           Media file = new Media("file:///Audio/song.mp3"); //Path to file
           MediaPlayer myPlayer = new MediaPlayer(file); 
           myPlayer.play();
       }