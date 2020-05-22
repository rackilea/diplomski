public void onClickRandomColor(View v) {
    Random rnd = new Random();
    int min = 0, max = 255;
    int randomRed = rnd.nextInt(max - min + 1) + min;
    int randomGreen = rnd.nextInt(max - min + 1) + min;
    int randomBlue = rnd.nextInt(max - min + 1) + min;
    Rset = randomRed;
    Gset = randomGreen;
    Bset = randomBlue;
}