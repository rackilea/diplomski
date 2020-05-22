char[][] charMap = new char[100][100];
    long startTime = System.currentTimeMillis();
    for(int i = 0; i < charMap.length; i++)
    {
        StringBuilder sb = new StringBuilder();
        for (char c : charMap[i]) {
            sb.append(c).append(" "); //since you want the space
        }
        System.out.println(sb.toString());
    }
    System.out.println((System.currentTimeMillis() - startTime) + " ms");