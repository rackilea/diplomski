void assign(BitBoard that) {
    this.high = that.high;
    this.low = that.low;
}

void inplaceAnd(BitBoard that) {
    this.high &= that.high;
    this.low &= that.low;
}

void inplaceAndNot(BitBoard that) {
    this.high &= ~that.high;
    this.low &= ~that.low;
}