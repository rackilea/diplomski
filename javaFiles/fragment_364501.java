if (in_file.hasNextInt()) {
    if (in_file.nextInt() == 0) 
        level[i][j] = '-';
    else if (in_file.nextInt() == 1)
        level[i][j] = '#';
}