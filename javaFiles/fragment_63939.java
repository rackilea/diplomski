void keyPressed() {
    if (boxes[randI][randJ].keyRight()) {
        boxes[randI][randJ].light = true;
        randI = (int)random(0, cols);
        randJ = (int)random(0, rows);
        keyIndex = int(random(97, 120));
        println(keyIndex, char(keyIndex));
    }
}