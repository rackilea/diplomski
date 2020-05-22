temp = result.get(result.size() - 1);
if(temp.length() < b){
    while(temp.length() < b)
        temp += ".";
}
else if(temp.length() > b)
    temp = temp.substring(0, b);
result.set(result.size() - 1, temp);