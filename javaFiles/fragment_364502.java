if (in_file.hasNextInt()) {
    int nextInt = in_file.nextInt();
    if (nextInt == 0) 
        level[i][j] = '-';
    else if (nextInt == 1)
        level[i][j] = '#';
}