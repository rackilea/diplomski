public boolean isEmpty()
{
    return options == null || options.length == 0
}

public int length()
{
    return isEmpty() ? 0 : options.length;
}

public String toString()
{       
    String result = topPrompt + "\n";
    for (i=0; i<lenth(); i++) {
         result += "(" + (i+1)+ ") " + options[i]; 
    }
    result  += "?->" + " " + bottomPrompt);
    return result;
}