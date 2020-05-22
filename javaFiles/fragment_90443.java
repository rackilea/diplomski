public RealNumber<Integer> add(Integer number) {
    return new RealNumber<Integer>(intValue() + number);
}
public RealNumber<Long> add(Long number) {
    return new RealNumber<Long>(longValue() + number);
}