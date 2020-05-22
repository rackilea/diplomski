public void populateArray()
{
    count = 0;
    boolean[] used = new boolean[50];
    while (count < 6) {
        randomNumber = 1 + randomGen.nextInt(49);
        if (!used[randomNumber]) ++count;
        used[randomNumber] = true;
    }


    int j = 0;
    for (int i = 1; i < used.length; ++i) {
        numberLine[j++] = i;
    }
}