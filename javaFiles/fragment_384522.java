for(int i = 0; i < words.length; i++) {
    String w = words[i];
    if(null!=w)
    {
        lengthTimes[i] =w.length();
    }
}
}


//here we should traverse upto length of the array.
for(int i = 0; i < lengthTimes.length; i++) { 
    System.out.println("Word-length " + (i+1) + ": " + lengthTimes[i]);
}