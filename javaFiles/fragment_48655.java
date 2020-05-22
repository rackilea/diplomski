while (read.hasNextInt()) {
    int val = read.nextInt();
    if (val == -1) {
        break;
    }
    buffer[i] = val;
    i++;
}