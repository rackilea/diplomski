public class Reverser {

    private int idx;
    private String text, revText;

    public static void main(String[] args) {
        Reverser greeting = new Reverser("Buildings");
        greeting.reverse();
        System.out.println(greeting.getText());
    }

    public void reverse() {
        if (idx == text.length())
            return;
        revText = text.charAt(idx) + revText;
        idx++;
        reverse();
    }

    public Reverser(String _text) {
        idx = 0;
        text = _text;
        revText = "";
    }

    public String getText() {
        return revText; 
    }

}