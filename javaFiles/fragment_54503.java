String[] splitStrNewLine = usersInfo.split("\n");

fileLength = splitStrNewLine.length();

for(int i=0; i<fileLength; i++){
    splitStrSpace = splitStrNewLine[i].split("[ ]"); \\specify delimiter you want to split
    for(int j=0; j<splitStrSpace.length(); j++){
        System.out.println(splitStrSpace[j]);
    }
}