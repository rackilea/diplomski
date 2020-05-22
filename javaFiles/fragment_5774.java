public class GridPanel extends JPanel {

private String[] COLUMNS = {"Name", "Frame 1", "Frame 2", "Frame 3", "Frame 4", "Frame 5",
        "Frame 6", "Frame 7", "Frame 8", "Frame 9", "Frame 10", "Total Sum"};

private JTextArea jTextAreaName;
public JTextArea jTextAreaTotalSum;
private JLabel labelName;
private JLabel labelFrame;
private JLabel labelSum;
private static String pattern = "[A-Za-z]*";
public static List<JTextArea> jTextAreas = new ArrayList<>();

public GridPanel(int numPlayers) {
    setLayout(new BorderLayout());
    createGrid(numPlayers);
}


public void createGrid(int numPlayers) {

    setLayout(new GridBagLayout());

    for (int y = 1; y <= numPlayers; y++) {

        createHeader();

        jTextAreaName = new JTextArea(2, 8);
        jTextAreaName.setEditable(true);
        addDocumentListener(jTextAreaName);

        add(jTextAreaName, GridBag.constraints(0, y, 1, 1));

        for (int i = 1; i <= 9; i++) {
            add(new BowlingFramePanel(2), GridBag.constraints(i, y, 1, 1));
        }
        add(new BowlingFramePanel(3), GridBag.constraints(10, y, 1, 1));

        jTextAreaTotalSum = new JTextArea(2, 8);
        jTextAreaTotalSum.setEditable(false);

        add(jTextAreaTotalSum, GridBag.constraints(11, y, 1, 1));
        jTextAreas.add(jTextAreaName);
    }

}

private void addDocumentListener(JTextArea jTextArea) {
    jTextArea.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            validateInputName();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            validateInputName();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            validateInputName();
        }
    });
}

private void validateInputName() {
    for (JTextArea jTextArea : jTextAreas) {

        String text = jTextArea.getText();
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);

        if (m.matches()) {
            jTextArea.setBackground(Color.GREEN);
            ifTextAreaIsEmptySetBackgroundColorWhite(jTextArea, text);
        } else {
            jTextArea.setBackground(Color.RED);
            ifTextAreaIsEmptySetBackgroundColorWhite(jTextArea, text);
        }
    }
}

private void ifTextAreaIsEmptySetBackgroundColorWhite(JTextArea jTextArea, String text) {
    if (text.isEmpty()) {
        jTextArea.setBackground(Color.WHITE);
    }
}

private void createHeader() {
    labelName = new JLabel(COLUMNS[0]);
    labelName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    add(labelName, GridBag.constraints(0, 0, 1, 1));

    for (int x = 1; x <= 10; x++) {

        labelFrame = new JLabel(" " + "Frame " + Integer.toString(x));
        labelFrame.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        add(labelFrame, GridBag.constraints(x, 0, 1, 1));
    }

    labelSum = new JLabel(" " + COLUMNS[11]);
    labelSum.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    add(labelSum, GridBag.constraints(11, 0, 1, 1));


}}