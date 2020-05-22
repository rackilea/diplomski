public static boolean unsafe(int y) {
    int x = b[y]; //Let's call the actual cell "x"
    for (int i = 1; i <= y; i++) { //For each queen before placed BEFORE the actual one, we gotta check if it's in the same row, column or diagonal.
        int t = b[y - i];
        if (t == x || t == x - i || t == x + i) {
            return true; //Uh oh, clash!
        }
    }
    return false; //Yay, no clashes!
}