ScratchItem[] items = listPlaylists(line2);

        DefaultListModel newListModel = new DefaultListModel();
        for(ScratchItem item : items) {
            newListModel.addElement(item);
        }

        JList list = new JList();
        list.setModel(newListModel);
        list.setVisible(true);
        add(list, BorderLayout.SOUTH);
        invalidate();