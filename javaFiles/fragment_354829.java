public class Dispenser extends Thread {

    List<Player> players = GameManager.getInstance().getRegisteredPlayers();
    List<JLabelObserver> observers = new ArrayList<>();

    public void run() {

       while (true) {
           System.out.println("alive");
           try {
               for (Player p : players) {
                   p.setAlk(p.getAlk() + p.getDifficulty()); // TODO too hard
                   notifyObservers(p)
               }
            } catch (ConcurrentModificationException e) {
                System.out.println("playerlist in use, retry");
            }
            try {
               sleep(1000); // TODO too short
            } catch (InterruptedException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
           }
        }
   }

   public static addObserver(JLabelObserver observer){
       observers.add(observer);
   }

   public static notifyObservers(Player player){
        for(JLabelObserver observer : observers){
             observer.update(player);
        }
   }
}