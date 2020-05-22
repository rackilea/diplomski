int errs = Math.abs(word1.length - input1.length);
int len = Math.min(word1.length, input1.length);
for (int i = 0; i < len; i++) {
    if (word1.charAt(i) != input1.charAt(i)) errs++;
}
// errs now holds the number of character mismatches