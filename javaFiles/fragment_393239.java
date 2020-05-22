package com.stackoverflow.spirit;

public class Spirit {
    private String name;
    private Party party;
    private SpiritType type;
    private static int id = 0;

    public static enum SpiritType {
        Grokk, Risp, Tyce, Daem, Celeste
    };

    public Spirit(String name, SpiritType type) {
        create(name, type);
    }

    public Spirit(SpiritType type) {
        create(null, type);
    }

    // This is to handle Java inexistance of default parameter values.
    private void create(String name, SpiritType type)
    {
        Spirit.id++;

        this.name = (name == null) ? (type.name() + " " + id) : name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Party getParty() {
        return party;
    }

    public SpiritType getType() {
        return type;
    }

    /**
     * Used internally by @see Party
     * @param party the party this Spirit belongs
     */
    public void setParty(Party party) {
        this.party = party;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}