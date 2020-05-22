class Player {
    int hp; 
    int mp;

    void use(Potion p) {
        p.use(this);
    }
}

interface Potion {
    void use(Player p);
}

class HPPotion implements Potion {
    public void use(Player p) {
        p.hp += 50;
    }
}

class MPPotion implements Potion {
    public void use(Player p) {
        p.mp += 50;
    }
}