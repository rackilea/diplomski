while ( scan.hasNextLine() ){
    word = scan.nextLine();
    if ( word.length() > 0 ){
        t.addWord(word);
    }else{
        break;
    }
}