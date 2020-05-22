public int lol(int a) {
    num = 0;
    for (int i = 0; i < object.getDices().size(); i++) {
        if (object.getDices().get(i) == a) {
            num += a;
        }
    }
    return num;
}