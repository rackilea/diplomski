while(line.hasNext()) {
    word2 = line.next();
    while(word.equals(word2)) {
        repeat++;
        if(line.hasNext()){
            word2 = line.next();
        } else {
            break;
        }
    }
    if(repeat!=1) {
        System.out.print(word + "*" + repeat + " ");
    }
    repeat = 1;
    word = word2;
}