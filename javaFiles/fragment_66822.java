public void convertToArray(){
    int count = 0;
    for (int j = 0; j < entrys.length; j++) {
        for (int i = 0; i < 2; i++) {
            entrys[j][i] = list.get(count++);
        }
    }
}