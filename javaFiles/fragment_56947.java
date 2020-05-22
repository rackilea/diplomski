int pwLength = 8;
Random numberGenerator = new Random();
char[] pw = new char[pwLength];
for(int i = 0; i<pwLength; i++){
    pw[i] = numberGenerator.nextInt(95) + 32;
}