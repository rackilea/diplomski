private boolean helper(a) {
    boolean b = false;
    switch (a) {
        case 2: b = b || condition_3;
        case 1: b = b || condition_2;
        case 0: b = b || condition_1;
    }
    return b;
}