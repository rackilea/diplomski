if(swapInt) {
    if(s1Length == 0 && s2Length != 0) {
        return 1;
    } else if (s2Length == 0 && s1Length != 0) {
        return -1;
    } else {
        return 0;
    }
} else {
    if(s1Length == 0 && s2Length != 0) {
        return -1;
    } else if (s2Length == 0 && s1Length != 0) {
        return 1;
    } else {
        return 0;
    }
}