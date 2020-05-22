public class Battle {
    //battle win function
    public Player winBattle(Player player){
        /**
         * win rules
         */
        player.setStatus("dead");
        return player;
    }

}