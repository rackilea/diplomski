public class Txt {

    private ArrayList<String> katakana = new ArrayList<>();

    public Txt() {
        for (int i = 0x30A0; i <= 0x30FF; i++) {
            katakana.add(String.valueOf(Character.toChars(i)));
        }
    }

    public ArrayList<String> getKatakana() {
        return new ArrayList<>(katakana);
    }   
}