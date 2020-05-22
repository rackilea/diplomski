int i = 0;
while (true) {
    if (i < new Random().nextInt(1000)) {
        break;
    }
    temp += i + " ";
    i++;
}