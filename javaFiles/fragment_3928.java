for(Iterator<JCheckBox> iterator = checkboxes.iterator(); iterator.hasNext();) {
    JCheckBox checkbox = iterator.next();
    if (checkbox.isSelected()) {
        System.out.println(checkbox.getText()
                + " was deleted");
        iterator.remove();
    }
}