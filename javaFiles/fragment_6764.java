public class Player {
    private int defense;
    private String name;

    public Player(int defense, String name) {
         this.defense = defense;
         this.name = name;
    }

    public int getDefense() {
         return this.defense;
    }

    public String getName() {
         return this.name;
    }
}

Player player = new Player(9000);
System.out.println(player.getName + " has defense + " player.getDefense());