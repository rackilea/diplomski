...
JOptionPane pane = new JOptionPane(message,  JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
JDialog getTopicDialog =  pane.createDialog(null, "New Topic");
getTopicDialog.setVisible(true);
if(null == pane.getValue()) {
    System.out.println("User closed dialog");
}
else {
    switch(((Integer)pane.getValue()).intValue()) {
    case JOptionPane.OK_OPTION:
        System.out.println("User selected OK");
        break;
    case JOptionPane.CANCEL_OPTION:
        System.out.println("User selected Cancel");
        break;
    default:
        System.out.println("User selected " + pane.getValue());
    }
}