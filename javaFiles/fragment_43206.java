public class Vocable{

    private String german;
    private String english;

    public Vocable(String pGerman, String pEnglish){
        english = pEnglish;
        german = pGerman;
    }

    public String getGerman(){
        return german;
    }

    public String getEnglish(){
        return english;
    }
}