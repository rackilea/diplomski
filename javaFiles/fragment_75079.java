public class Filter{

    String letters;

    public Filter(String letters) {
        this.letters = letters;
    }

    public boolean contains (char character){
        for(int i = 0; i < letters.length(); i++) {
            if(letters.charAt(i) == character)
                return true;
        }
        return false;
    }

    public String toString (){
        return "Filter(" + letters + ")";
    }
}