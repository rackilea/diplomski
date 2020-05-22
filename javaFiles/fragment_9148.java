public class Main{
    public static void main (String[] args) {
        WordGroup firstWordGroup = new WordGroup.word("You-can-discover-more-about-a-person-in-an-hour-of-plau-tban-in-a-year-of-conversation");
        WordGroup secondWordGroup = new WordGroup ("When-you-play-play-hard-when-you-work-dont-play-at-all");

        String[] firstWordArray =  firstWordGroup.getWordArray();
        for( String word : firstWordArray) { 
            System.out.println(word);
        }
        //second loop is very similar.
    }   
}