int N = 20; //20 Random numbers
int[] randomNumber = new int[N];
int[] answer = new int[N/2];

//Generate random numbers of size N
for (int i = 0; i < N; i++) {
    randomNumber = generateRandom(0, 100);
}

//populate answers
for (int i = 0; i < answer.length; i++) {
    answer[i] = randomNumber[i*2] + randomNumber[i*2 + 1];
}

//Generate a random number from [min, max]
private int generateRandom(int min, int max) {
    return min + (int)(Math.random() * ((max - min) + 1));
}