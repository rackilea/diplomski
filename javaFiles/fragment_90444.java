public RealNumber<Integer> add(Integer number){
    if (!(this instanceof Integer)) {
        throw new IllegalArgumentException("You can't do this...");
    }
    return new RealNumber<Integer>(intValue() + number);
}