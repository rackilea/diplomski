String Cleaner = TopField.getText();
Cleaner = Cleaner.toLowerCase();
StringBuilder Combiner = new StringBuilder(Cleaner);
int x =0;
while (x < Combiner.length()) {
    char c = Combiner.charAt(x);
    if (c >= 'a' && c <= 'z' || c == ' ') {
        Combiner.deleteCharAt(x);
    } else {
        x++;
    }
}