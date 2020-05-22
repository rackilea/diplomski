public int railGunAttack() {

    int randomNumber = (int) (Math.random() * 100 + 1);
    int damageDelt = 0;

    if (randomNumber > 0 && randomNumber < 50) {
        damageDelt = 2 * randomNumber;
        System.out.println("Railgun did " + damageDelt + " Damage");
    } else if (randomNumber > 50 && randomNumber < 80) {
        damageDelt = 4 * randomNumber;
        System.out.println("Railgun did " + damageDelt + " Damage");
    } else if (randomNumber > 80 && randomNumber < 100) {
        damageDelt = 50 - randomNumber;
        System.out.println("Railgun did " + damageDelt + " Damage " + "Railgun projectiles glazed the target");
    } else {
        System.out.println("Railgun missed target");
    }
    return damageDelt;
}