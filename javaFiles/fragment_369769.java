private String[] partscovered; // This is deliberately not assigned

public Warranty(int monthnum) {
    this.monthnum = monthnum;
    this.partscovered = new String[]{"Engine", "Mirrors", "Electrics", "Body", "Wheels"};
}

public Warranty(int monthnum,String[] partscovered) {
    this.monthnum = monthnum;
    this.partscovered = partscovered;
}