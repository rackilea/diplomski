//split at , only if it's not within ""
String[] packages=input.split(",(?=([^\"]*\"[^\"]*\")+[^\"]*$)");
for(String pack:packages)
{
    String[] output=pack.split("(?=uses:=)");
    output[0];//key
    if(output.length==2)//incase if there's no value
    output[1];//value
}