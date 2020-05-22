public int stringMatch(String a, String b) {
    int counter = 0;

    for(int i = 0; ((i < a.length() - 2) && (i < b.length() -2)); i++){

        String aSub = a.substring(i, i + 2);
        String bSub = b.substring(i, i + 2);

        if(aSub.equals(bSub)){
        counter++;
        }
    }
return counter;
}