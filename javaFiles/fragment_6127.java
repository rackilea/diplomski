void searchPhrase(String[] phrase){
    searchResult = new int[phrase.length];
    int j=0;
    for (int i=0; i<frase.length;i++){
        for (int k=0; k<alphabet.length;k++){        
            if (!phrase[i].equals(alphabet[k])){
                System.out.println("\nLetter "+phrase[i]+" was not found when comparing it to "+alphabet[k]);
                k++;
            }
            else{               
                System.out.println("\nLetter "+phrase[i]+" was found when comparing it to "+alphabet[k]);
                searchResult[j] = i;
                k=0;
                break;
            }
        }
    }
}