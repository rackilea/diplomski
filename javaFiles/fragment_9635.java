public static void move(int number, char start, char help, char end) {
    if (number == 1) {
        print("Move the top disk from " + start + " to " + end);
        count++;
    } else {
        int stepsBeforeMove1 = count;
        move(number - 1, start, end, help);
        int stepsAfterMove1 = count;
        print("Move the top disk from " + start + " to " + end);
        count++;
        int stepsBeforeMove2 = count; //this is just for the sake of clarity
        move(number - 1, help, start, end);
        int stepsAfterMove2 = count;
        assert ((stepsAfterMove1-stepsBeforeMove1) + (stepsAfterMove2-stepsBeforeMove1) + 1) == Math.pow(2,number) - 1;
    }
}