if (index > denoms.length - 1)
    return 0;
if (index == denoms.length - 1) {
    // one denom remaining
    if (amount % denoms[denoms.length - 1] == 0) {
        return 1;
    }
    else {
        return 0;
    }
}