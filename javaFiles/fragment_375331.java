scores = new int[2][framesToBowl];
for(int i = 0; i < framesToBowl; i++) {
    x = (int)(Math.random() * 9);
    if(x == 0) y = (int)(Math.random() * 9);
    else y = (int)(Math.random() * (9 - x));
    scores[0][i] = x;
    scores[1][i] = y;
}