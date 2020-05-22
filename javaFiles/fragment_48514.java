StringBuilder changes = new StringBuilder("%: ");
for(char ch='a';ch<='z';ch++){
    numberlc=numberOccurances(line, ch);
    char upperch=Character.toUpperCase(ch);
    numberuc=numberOccurances(line, upperch);
    for(int y=0; y<line.length(); y++){
        if(line.charAt(y)==ch)
            line=line.substring(0,y) + upperch + line.substring(y+1);
        else if(line.charAt(y)==upperch)
            line=line.substring(0,y) + ch + line.substring(y+1);
    }
    if(numberlc>0)
        changes.append(ch + " " + numberlc + ":");
    if(numberuc>0)
        changes.append(upperch + " " + numberuc + ":");
}
if (changes.length() > 3)
    line += changes.toString();
writer.println(line);