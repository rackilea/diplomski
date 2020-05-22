public class ContainsAnonymousInnerClass {
    public String s = "";
    public void m() {
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.toString();
            }
        };
    }
}