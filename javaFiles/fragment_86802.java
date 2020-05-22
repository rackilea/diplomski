if(line.charAt(y)=='M'){
    line=line.substring(0,y) + 'm' + line.substring(y+1);
}
else if(line.charAt(y)=='m'){//pay attention to this line
    line=line.substring(0,y) + 'M' + line.substring(y+1);
}