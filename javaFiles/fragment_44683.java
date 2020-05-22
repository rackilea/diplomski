public int firstUniqChar(String s) {
    int count=-1;
    if(s == null || s.length() < 1) {
        return -1;
    }
    else if (s.length() == 1) {
        return 0;
    }

    for(Character ch:s.toCharArray()){
        if(s.indexOf(ch)==s.lastIndexOf(ch)){
            count=s.indexOf(ch);    
            break;
        }

    }  
    //If no unique character is found, count will still be -1  
    return count;    
}