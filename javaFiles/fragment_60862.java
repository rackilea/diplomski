public Knoten(String type) throws IllegalArgumentException { // throws unchecked exception is optional
    if (type.equals("BASE") || type.equals("WORD") || type.equals("ROOT") || type.equals("AFFIX")) {
        this.type = type;
    } else {
        throw new IllegalArgumentException("invalid type");
    }

}