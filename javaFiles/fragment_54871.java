while (true) {
   if (rnd.nextInt(30) == 3) {
      Platform.runLater(() -> pressBtn());            
   } else if (rnd.nextInt(30) == 7) {
       Platform.runLater(() -> releaseBtn());            
   }
}