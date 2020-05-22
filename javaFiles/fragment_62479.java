public MainPanel mainPanelReference;

JButton left;
JButton right;

public ButtonPanel(MainPanel mainPanelReference) {
    this.left = new JButton("Left");
    this.right = new JButton("Right");

    add(left);
    add(right);

    this.mainPanelReference = mainPanelReference;

    left.addActionListener(mainPanelReference);
    right.addActionListener(mainPanelReference);
}