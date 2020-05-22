// Import 'java.util.Random' at the top of your file

Random rand = new Random();
int max = 9999;
int min = 1000;
int rnd = rand.nextInt((max - min) + 1) + min;

String fullString = firstname
    + secondname.substring(0, Math.min(5, secondname.length()))
    + String.valueOf(rnd);