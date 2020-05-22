int openArray = 0;

for(int i = 0; i<markbook.length; i++) {
    if(markbook[i] == null)
    {
        openArray = i;
        break;
    }
}