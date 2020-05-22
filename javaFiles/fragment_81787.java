if (e.getSource() == confirmBtn) {
    if ((!isMaximum && selectionIndecies.size() <= numNeeded) || selectionIndecies.size() == numNeeded) {
        Collections.sort(selectionIndecies);
        OpeningGUI.publishSelectedIndex(selectionIndecies);
        dispose();
    }
}