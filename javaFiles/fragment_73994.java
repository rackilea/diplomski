private int checkLine(int position){
    int counter = 0;
    Scanner text = new Scanner(searchBlock.substring(0,position));

    while(text.hasNextLine()){
        counter++;
        text.nextLine();
    }
    return counter - 1;
}