public class Character {
    private HashMap<String, String> stats;
    public String getStat(String name) {
        return stats.get(name);
    }
}

// elsewhere
Character tanis = new Character("Tanis");
System.out.println(tanis.getStat("Dexterity"));