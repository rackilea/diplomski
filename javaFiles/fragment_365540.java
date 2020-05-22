public static boolean hasThreeNonconsecutiveThrees(int... values) {
    int count = 0, streak = 0;
    for (int value : values) {
        if (value != 3)
            streak = 0;
        else if (++streak == 2)
            return false; // Found two consecutive (adjacent) 3s
        else
            count++;
    }
    return (count >= 3);
}