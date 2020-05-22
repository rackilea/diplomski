if (to.c == from.c && to.r == from.r) {
    // reached destination
    return;
}

if (to.c > from.c) {
    // move right
} else if (to.c < from.c) {
    // move left
} else {
    // random step left/right
}

if (to.r > from.r) {
    // move down
} else if (to.r < from.r) {
    // move up
} else {
    // random step up/down
}

// take next step