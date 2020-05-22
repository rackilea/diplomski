outerLoop: for (int i = 0; i < max; i++) {
    innerLoop: for (int j = 0; j < max2 - i; j++) {
        if (something) {
            break outerLoop;
        }
        //...
    }
}