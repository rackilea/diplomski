public class FindWord {

    public static void main(String[] args) {

        FindWord f = new FindWord();

        f.findWords("As you can test, we can put as many test in test as we test", "test");
    }


    public void findWords(String str, String search) {//This can easily be added into your project

        String fileText = str;//text from file
        String searchWord = search;//the word being searched
        List<Integer> indexOfSearch = new ArrayList<>();
        int index = fileText.indexOf(searchWord);
        indexOfSearch.add(index);
        while (index >= 0) {
            index = fileText.indexOf(searchWord, index + 1);
            indexOfSearch.add(index);
        }
        System.out.println(fileText);//print the text from file
        for (int j = 0; j < indexOfSearch.size() - 1; j++) {//each index of search word
            String spaces = "";//spaces to caret
            int indexTo = 0;//how many spaces will be added
            if(j < 1){
            indexTo = indexOfSearch.get(j);//the first index
            }else{            
                indexTo = (indexOfSearch.get(j) - indexOfSearch.get(j - 1) - 1);//all other indexes in the row
            }            
            for (int i = 0; i < indexTo; i++) {//add appropriate number of spaces to word  
                spaces += " ";//add a space
            }
            System.out.print(spaces + "^");//print the spaces and spaces
        }
        System.out.println("");//used to make the print slightly easier to look at.
    }

}