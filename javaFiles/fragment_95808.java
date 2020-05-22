public void attack() {
    if(chance > 0.0 /* Some arbitrary value */) {
        double damageToApply = minRange + chance*(maxRange - minRange);
        System.out.println("Applying damage: " + damageToApply);
    } else {
        System.out.println("Unable to apply damage, flee!");
    }
}