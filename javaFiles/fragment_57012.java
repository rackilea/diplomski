isTrue = true
int magicSum = sumOfFirstDiagonal
if (magicSum != sumOfSecondDiagonal) {isTrue = false; return}
for each row
    if (magicSum != sumOfRow) {isTrue = false; return}    
for each column
    if (magicSum != sumOfColumn) {isTrue = false; return}