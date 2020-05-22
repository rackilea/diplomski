Object selectedValue = jOptionPane.getValue();
int dialogResult = JOptionPane.CLOSED_OPTION;
if (selectedValue != null) {
    dialogResult = Integer.parseInt(selectedValue.toString());
}

switch (dialogResult) {
    case JOptionPane.YES_OPTION:
        LOG.info("yes pressed");
        break;
    case JOptionPane.NO_OPTION:
        LOG.info("no pressed");
        break;
    case JOptionPane.CLOSED_OPTION:
        LOG.info("closed");
        break;
    default:
}