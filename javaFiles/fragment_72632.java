public enum Term implements Query {
    BEEF, CHICKEN, FISH, CARROTS, PEAS, ONIONS, RICE, BEANS;

    @Override
    public EnumSet<Term> getTerms() {
        return EnumSet.of(this);
    }
}