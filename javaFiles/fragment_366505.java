class BoomState {
    private final List<Explosion> booms = new ArrayList<Explosion>();

    public void addBoom() {
        booms.add(new Explosion());
    }

    public List<Explosion> getBooms() {return Collections.unmodifiableList(booms);}
}