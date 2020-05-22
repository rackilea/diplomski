final JList<MenuItem> firstJList = new JList<MenuItem>();
    DefaultListModel<MenuItem> firstModel = new DefaultListModel<MenuItem>();
    for (MenuItem item : RestaurantArrayList.items) {
        firstModel.addElement(item);
    }
    firstJList.setModel(firstModel);

    final JList<MenuItem> secondJList = new JList<MenuItem>();
    secondJList.setModel(new DefaultListModel<MenuItem>());

    JButton button = new JButton(">>");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (firstJList.isSelectionEmpty())
                return;
            List<MenuItem> selection = firstJList.getSelectedValuesList();
            DefaultListModel<MenuItem> model = (DefaultListModel<MenuItem>) secondJList.getModel();
            for (MenuItem selected : selection) {
                if (!model.contains(selected))
                    model.addElement(selected);
            }
        }
    });