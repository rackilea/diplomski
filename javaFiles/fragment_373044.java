public class Checker {

    public static final Comparator<Player> asc = new Comparator<Player>() {     
        public int compare(Player o1, Player o2) {
             if(o1.score != o2.score)
                 return o1.score - o2.score;
             else
                 return o1.name.compareTo(o2.name);
        }
    };

    public static final Comparator<Player> desc = new Comparator<Player>() {        
        public int compare(Player o1, Player o2) {
             if(o1.score != o2.score)
                 return o2.score - o1.score;
             else
                 return o2.name.compareTo(o1.name);
        }
    };
}