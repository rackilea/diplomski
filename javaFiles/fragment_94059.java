int x = 0, y = 0;
for(int i = 0; i < srcArray.length; i++) {
    if (x > dstArray[y].length) {
        x = 0;
        y++;
    }
    if (y > dstArray.length) {
        break;
    }
    dstArray[y][x] = srcArray[i];
}