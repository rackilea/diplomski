for (int i=0; i < length; i++) {
    if (array[i] >= 'a' && array[i] <= 'z') {
        int currDiff = (int)array[i] - (int)'a';
        int newPos = (int)'a' + ((rotator + currDiff) % 26);
        array[i] = (char)newPos;
    }
    else if (array[i] >= 'A' && array[i] <= 'Z') {
        int currDiff = (int)array[i] - (int)'A';
        int newPos = (int)'A' + ((rotator + currDiff) % 26);
        array[i] = (char)newPos;
    }
}