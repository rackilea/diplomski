int [] tabMaxMin = {1, 4, 8, -4, 11, 0};
    int max = tabMaxMin[0];
    int min = tabMaxMin[0];
    for (int i=1; i < tabMaxMin.length; i++) {
        if(min >= tabMaxMin[i])
            min = tabMaxMin[i];
        if(max <= tabMaxMin[i])
            max = tabMaxMin[i];
    }
    System.out.println("MAX=" + max);
    System.out.println("MIN=" + min);

}