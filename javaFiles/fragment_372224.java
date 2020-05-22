public static class BalanceSheet {
    private Entry liability;
    private Entry asset;
    public Entry getLiability() {
        return liability;
    }
    @XmlElement(name = "LIABILITY")
    public void setLiability(Entry liability) {
        this.liability = liability;
    }
    public Entry getAsset() {
        return asset;
    }
    @XmlElement(name = "ASSET")
    public void setAsset(Entry asset) {
        this.asset = asset;
    }
    public BalanceSheet(Entry asset, Entry liability) {
        super();
        this.liability = liability;
        this.asset = asset;
    }
}

public static class Entry {
    private String label;
    private int amount;

    public int getAmount() {
        return amount;
    }

    @XmlValue
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    @XmlAttribute(name="label")
    public void setLabel(String label) {
        this.label = label;
    }

    public Entry() {
    }

    public Entry(String label, int amount) {
        this.label = label;
        this.amount = amount;
    }
}