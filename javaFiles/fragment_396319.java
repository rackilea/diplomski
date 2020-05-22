ScratchItem[] items = listPlaylists(line2);

DefaultListModel newListModel = new DefaultListModel();
for(ScratchItem item : items) {
    newListModel.addElement(item);
}

// JList list = new JList(); // *** don't create a new JList

// originalList refers to the original displayed JList
originalList.setModel(newListModel);

// list.setVisible(true);
// add(list, BorderLayout.SOUTH);
// invalidate();