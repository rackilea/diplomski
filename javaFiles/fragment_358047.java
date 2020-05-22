public class NotElegant {

    public static void main(String[] args){
        String text = "doctors found many cancer related chest problems in japan during second world war.";
        String term = "cancer problems";
        System.out.println(getWordsNearEachOther(text,term,3));
    }
    public static String getWordsNearEachOther(String text, String term, int distance){
        String word1= term.split(" ")[0];
        String word2= term.split(" ")[1];
        String firstWord = text.indexOf(word1)<text.indexOf(word2)?word1:word2;
        String secondWord = text.indexOf(word1)<text.indexOf(word2)?word2:word1;
        if(!(text.contains(word1) && text.contains(word2))){
            return null;
        }        
        else if(text.substring(text.indexOf(firstWord), text.indexOf(secondWord)+secondWord.length()).split(" ").length>distance+1){
            return null;
        }
        return text.substring(text.indexOf(firstWord), text.indexOf(secondWord)+secondWord.length());
    }
}