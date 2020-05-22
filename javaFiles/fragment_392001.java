StringBuffer text = new StringBuffer();
int rowLen = array.length;
int colLen = array[0].length;
for(int a=0; a<colLen; a++)
    for(int b=0; b<rowLen; b++)
        if(array[b][a]!=0)
            text.append(array[b][a]);
System.out.println(text.toString());