// code not tested
@Override
public void update(Observable o, Object arg) {
    SwingUtilities.invokeLater(() -> {
        result = (double) arg;
        jtp.setText("Current value of result is " + result);
    });
}