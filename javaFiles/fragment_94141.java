int encPos = aPos;
if (key >= 0) {
    encPos = (aPos + key) % str.length();
} else {
    // the key may be bigger than the alphabet length
    encPos = (str.length() + ((key + aPos) % str.length())) % str.length();
}
char ec = str.indexOf(encPos);