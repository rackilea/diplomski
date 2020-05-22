System.out.println(notes.size());
for (XML note : notes) {
    String n = note.getNode("notes", "note");
    System.out.println(n);
    JLabel lbl = new JLabel(n);
    lbl.setVisible(true);
    notesPanel.add(lbl);
}
notesPanel.validate();