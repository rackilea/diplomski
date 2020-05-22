public static int guessNum (int num){
    if (num == 0){
        throw new IllegalArgumentException();
    }

    if (num > 0){
        return 1;
    }

    return 0; //The other conditions were not met so this must be the result
}