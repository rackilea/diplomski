@Override
public String toString(){
    String str = "The Social Security Numbers you entered are:\n";
    for(int x=0; x< arrayCount; x++)
        str += SSNumber[x] + "\n";
    return str;
}