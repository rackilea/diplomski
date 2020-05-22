BitBoard tmp = new BitBoard(0, 0);
BitBoard result = new BitBoard(0, 0);
for (...) {
    // Let's say, you get a, b and c as inputs.
    // You should compute a&b | a&~b
    // Let's assume, none of a, b, c may be overwritten.
    tmp.assign(a);
    tmp.inplaceAnd(b);
    result.assign(a);
    result.inplaceAndNot(c);
    result.inplaceOr(tmp);    
}