public class CountVowels{
    String paragraph;
    public CountVowels(String paragraph){
        this.paragraph = paragraph;
        countVowels(paragraph);
    }

    int vowelTotal = 0;
    int sentenceNumber = 0;
    public void countVowels(String paragraph){
        for(int c = 0; c < paragraph.length(); c++){
            if( paragraph.charAt(c) == 'a' || paragraph.charAt(c) == 'e' || paragraph.charAt(c) == 'i' || paragraph.charAt(c) == 'o' || paragraph.charAt(c) == 'u' || paragraph.charAt(c) == 'y'){
                vowelTotal++; //Counts a vowel
            } else if( paragraph.charAt(c) == '.' || paragraph.charAt(c) == '!' || paragraph.charAt(c) == '?' ){
                sentenceNumber++; //Used to tell which sentence has which number of vowels
                System.out.println("Sentence " + sentenceNumber + " has " + vowelTotal + " vowels.");
                vowelTotal = 0; //Resets so that the total doesn't keep incrementing
            }
        }
    }
}