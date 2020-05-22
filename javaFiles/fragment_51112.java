static E2 E1toE2(E1 value) {
    return E2.values()[value.ordinal()];
}

static E1 E2toE1(E2 value) {
    return E1.values()[value.ordinal()];
}