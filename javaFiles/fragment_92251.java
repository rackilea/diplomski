GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);

        gridBagLayout.rowHeights = new int[]{40, 40, 190, 190, 50};
        gridBagLayout.columnWidths = new int[]{40, 50, 70, 70, 700, 70, 50};

        panel.add(idTxt, newComponent(0, 0, 1, 1));

        panel.add(id, newComponent(1, 0, 1, 1));

        panel.add(pathTxt, newComponent(2, 0, 1, 1));

        panel.add(path, newComponent(3, 0, 1, 1));

        panel.add(new JLabel(""), newComponent(4, 0, 1, 1));

        panel.add(levelTxt, newComponent(5, 0, 1, 1));

        panel.add(level, newComponent(6, 0, 1, 1));

        panel.add(appellationTxt, newComponent(0, 1, 1, 1));

        panel.add(appellation, newComponent(1, 1, 6, 1));

        panel.add(scrollAreaDesc, newComponent(0, 2, 7, 1));

        panel.add(childrenTableScrollPane, newComponent(0, 3, 7, 1));

        panel.add(panelButtons, newComponent(0, 4, 6, 1));