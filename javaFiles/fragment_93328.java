public enum Attack {
    MELEE(2) {
        @Override
        public int getDamage(int circumstances) {
            // customized behavior
        }
    },
    RANGED(1);

    private final int baseStrength;

    private Attack(int strength) {
        this.baseStrength = strength;
    }

    public int getDamage(int circumstances) {
        // default behavior for all attacks
    }
}