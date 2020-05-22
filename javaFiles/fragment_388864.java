int startIndex = 0;
int count = 0;
while ( true ) {
    int newIndex = line.indexOf(fileDelimiter, startIndex);
    if ( newIndex == -1 ) {
        break;
    } else {
        startIndex = newIndex + 1;
        count++;
    }
}