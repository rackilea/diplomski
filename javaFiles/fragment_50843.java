public static int iterate() {
    int x = 10;
    do {
        if (getRandNum(x) == 1) {
            done = true;
        }
        else {
            if (x > 1) {
                x--;
            } 
            else {
                x = 1;
                done = true;
            }
        }
    } while (!done);

    return x;
}