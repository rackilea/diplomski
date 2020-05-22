private class courseAL implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            Start_round sr = new Start_round();
            sr.CourseName = (String) e.getItem();
            // alternate:
            // JComboBox cb = (JComboBox) e.getItemSelectable();
            // sr.CourseName = (String) cb.getSelectedItem();
            System.out.println(sr.CourseName);
        }
    }
}