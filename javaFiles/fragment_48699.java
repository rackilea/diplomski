public class MorseTranslator {
private char[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
        'X', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        ' ' };//Changed this to char to save some memory and to help my methods :3

private String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
        "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
        "--..", ".----", "..---", "...--", "....-", ".....", "-....",
        "--...", "---..", "----.", "-----", "|" };

private String toMorse(String text) {
    char[] characters = text.toUpperCase().toCharArray();
    StringBuilder morseString = new StringBuilder();
    for (char c : characters) {
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == c) {
                morseString.append(morse[i]+" ");
                break; 
            }
        }
    }
    return morseString.toString();
}

private  String fromMorse(String text){
    String[] strings = text.split(" ");
    StringBuilder translated = new StringBuilder();
    for(String s : strings){
        for(int i=0; i<morse.length; i++){
            if(morse[i].equals(s)){
                translated.append(alpha[i]);
                break;
            }
        }
    }
    return translated.toString();
}

public MorseTranslator(){
    String input = "Hello there";
    String morse = toMorse(input);
    String translated = fromMorse(morse);
    System.out.println("Input: "+input);
    System.out.println("Morse: "+morse);
    System.out.println("Back From morse: "+translated);
}
}