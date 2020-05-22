public Compare plus (int x) {
    return new Compare(number + x);
}

public Compare plus (Compare x) {
    return new Compare(number + x.number);
}