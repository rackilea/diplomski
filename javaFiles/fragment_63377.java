while (w.hasNextLine()) {
    String lineW = w.nextLine();
    countLinesInW++;
    while(s.hasNextLine()) {
        String lineS = s.nextLine();
        if(lineS.equals(lineW)){
            j++;
        }
    }
}