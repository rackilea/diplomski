public class ConnectedScrollBarsApp {
    private static volatile boolean isConnected;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Connected Scroll Bars");
        frame.getContentPane().setLayout(new GridLayout(1, 3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane leftScrollPane = getScrollPane("left", 50);
        frame.getContentPane().add(leftScrollPane);

        JCheckBox connectedCheckBox = getConnectedCheckBox();
        frame.getContentPane().add(connectedCheckBox);

        JScrollPane rightScrollPane = getScrollPane("right", 100);
        frame.getContentPane().add(rightScrollPane);

        setUpScrollBarAdjustmentListener(leftScrollPane.getVerticalScrollBar(), rightScrollPane.getVerticalScrollBar(), connectedCheckBox);
        setUpScrollBarAdjustmentListener(rightScrollPane.getVerticalScrollBar(), leftScrollPane.getVerticalScrollBar(), connectedCheckBox);

        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private static void setUpScrollBarAdjustmentListener(JScrollBar source, JScrollBar otherScrollBar, JCheckBox connectedCheckBox) {
        ConnectedScrollBarAdjustmentListener listener = new ConnectedScrollBarAdjustmentListener(otherScrollBar, source.getValue(), connectedCheckBox);
        source.addAdjustmentListener(listener);
    }

    private static JScrollPane getScrollPane(String side, int lineCount) {
        String panelContent = getPanelContent(side, lineCount);
        JTextArea panelArea = new JTextArea(panelContent);
        JScrollPane scrollPane = new JScrollPane(panelArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private static JCheckBox getConnectedCheckBox() {
        ToggleScrollBarConnectionListener checkBoxListener = new ToggleScrollBarConnectionListener();
        JCheckBox checkBox = new JCheckBox("Connected?");
        checkBox.addActionListener(checkBoxListener);
        return checkBox;
    }

    private static String getPanelContent(String side, int lineCount) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= lineCount; i++) {
            sb.append("This is ");
            sb.append(side);
            sb.append(" line ");
            sb.append(i);
            sb.append("\n");
        }

        return sb.toString();
    }

    private static class ToggleScrollBarConnectionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            isConnected = ((JCheckBox) e.getSource()).isSelected();
        }
    }

    private static class ConnectedScrollBarAdjustmentListener implements AdjustmentListener {
        private final JScrollBar otherScrollBar;
        private int thisPreviousValue;
        private final JCheckBox connectedCheckBox;

        public ConnectedScrollBarAdjustmentListener(JScrollBar otherScrollBar, int thisPreviousValue, JCheckBox connectedCheckBox) {
            this.otherScrollBar = otherScrollBar;
            this.thisPreviousValue = thisPreviousValue;
            this.connectedCheckBox = connectedCheckBox;
        }

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            if (!isConnected) {
                this.thisPreviousValue = e.getValue();
                return;
            }

            connectedCheckBox.setEnabled(false);
            isConnected = false;
            JScrollBar thisScrollBar = (JScrollBar) e.getSource();

            double thisScrollBarPreviousRelativePosition = getRelativePosition(thisScrollBar, thisPreviousValue);
            double thisScrollBarLatestRelativePosition = getRelativePosition(thisScrollBar, e.getValue());
            double thisScrollBarRelativePositionChange = thisScrollBarLatestRelativePosition - thisScrollBarPreviousRelativePosition;

            int otherScrollBarCurrentPosition = otherScrollBar.getValue();
            int otherScrollBarNewPosition = (int) (otherScrollBarCurrentPosition + (otherScrollBar.getMaximum()  * thisScrollBarRelativePositionChange));

            otherScrollBar.setValue(otherScrollBarNewPosition);
            thisPreviousValue = e.getValue();
            isConnected = true;
            connectedCheckBox.setEnabled(true);
        }

        private double getRelativePosition(JScrollBar scrollBar, double value) {
            return value / scrollBar.getMaximum();
        }
    }

}