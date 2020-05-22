public class MyKeySelectionManager implements KeySelectionManager {

    private Timer timeout;
    private StringBuilder pattern = new StringBuilder(32);

    public MyKeySelectionManager() {
        timeout = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pattern.delete(0, pattern.length());
            }
        });
        timeout.setRepeats(false);
    }

    @Override
    public int selectionForKey(char aKey, ComboBoxModel<?> model) {
        timeout.stop();
        pattern.append(Character.toLowerCase(aKey));
        String match = pattern.toString();
        for (int index = 0; index < model.getSize(); index++) {
            String text = model.getElementAt(index).toString().toLowerCase();
            if (text.startsWith(match)) {
                timeout.start();
                return index;
            }
        }

        timeout.start();
        return -1;
    }

}