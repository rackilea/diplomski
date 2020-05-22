char[] keyW = {'A', 'L', 'O', 'P'};
char[] invAlphabet = {'X', 'A', 'P', 'B', 'C'};

//create boolean array
boolean[] mark = new boolean[128];
Arrays.fill(mark, false);

//mark which characters are present in keyW array
for (char ch : keyW) {
    mark[ch] = true;
}

// find number of duplicate character in invAlphabet array
int duplicateCount = 0;
for (char ch : invAlphabet) {
    if (mark[ch]) {
        duplicateCount++;
    }
}

// create new array
// size of new array = invAlphabet array length - duplicate number of character in invAlphabet array
char[] noDuplicateArray = new char[invAlphabet.length - duplicateCount];

//add character in new array
int idx = 0;
for (char ch : invAlphabet) {
    if (!mark[ch]) {
        noDuplicateArray[idx++] = ch;
    }
}