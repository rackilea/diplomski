public void getRandomElementsOfArray(String[] array)
{
    int maxLength = 200; // Insert length of your array
    int[] usedRandoms;
    String[] randomElements = String[20];
    int random = new Random().nextInt();

    for(int i = 0; i<21; i++) // Loops are NOT my strongest point. you'd better check this
    {
        while(random > maxLength || random < 0 || !Arrays.asList(usedRandoms).contains(random)) // Loop while random is smaller then 0 (the smallest index) or bigger then the length of your array or already used
        {
            random = new Random();
        }


        randomElements[i] = array[random];
        usedRandoms[i] = random;
    }
}