String text = " my text ";
char[] trimChars = {'\u00A0', ' '};//Add anything else you like to trim.
bool isSpaceBefore = false, isSpaceAfter = false;
do {
    isSpaceAfter = false;
    isSpaceBefore = false;
    for(int c=0; c<trimChars.length; c++) {
        isSpaceBefore = text.indexOf(trimChars[c]) == 0;
        isSpaceAfter = text.lastIndexOf(trimChars[c]) == text.length-1;
    }
    if(isSpaceAfter) text = text.substring(0, text.length-1);
    if(isSpaceBefore) text = text.substring(1);
}
while(isSpaceBefore || isSpaceAfter);