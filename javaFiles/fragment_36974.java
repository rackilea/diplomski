class CombatProcess extends GameProcess {
    public void hit(Player puncher, Player beaten) {
        if (beaten.getState().isAlive()) {
           Weapon oneWeapon = one.getCurrentWeapon();
               ...
        }
    }
}