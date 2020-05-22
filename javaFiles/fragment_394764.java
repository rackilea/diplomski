for (Iterator<String> i = fileWordList.iterator(); i.hasNext(); ) {
    String s = i.next();
    for(Iterator<String> j = stopWordList.iterator(); j.hasNext();){
        if (j.next() == s){ // consider using equals here
           i.remove();
           break; // No need to continue checking.
        }
    }

}