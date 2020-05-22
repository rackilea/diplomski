public class BisectionIterations extends JFrame
implements ActionListener {

private JTextArea textArea = new JTextArea("This text should display");
private JScrollPane scrollPane = new JScrollPane(textArea);
private JButton closeBtn = new JButton("Close");
//Array
Double[] iterationBi = new Double[1000];

public BisectionIterations(Double[] iter) {
this.iterationBi = iter;
setLayout(new BorderLayout());
setSize(500, 400);
setTitle("Bisection Method Iterations");
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setLocationRelativeTo(null);
setResizable(false);

JPanel middle = new JPanel(new FlowLayout());
middle.add(scrollPane);
textArea.setEditable(false);
textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
scrollPane.setPreferredSize(new Dimension(490, 330));
add("Center", middle);

JPanel bottom = new JPanel(new FlowLayout());
middle.add(closeBtn);
closeBtn.addActionListener(this);
add("South", bottom);
displayIterations();

setVisible(true);
}

public void actionPerformed(ActionEvent e) {
if (e.getSource() == closeBtn) {
    dispose();
}
}

public void displayIterations() {
String j = "";
for (int i = 1; i < 999; i++) {
    if (iterationBi[i] == null) {

    } else {
        j += "Approximation for iteration '" + i + "' = " +iterationBi[i] + "\n";
    }
}
//textArea.setText(j);
}

public static void main(String args[]){
Double s[];
s = new Double[1000];
for(int i=0;i<1000;i++) {
    s[i]=(double)i;
}
BisectionIterations b=new BisectionIterations(s);
}
}