final JComboBox simpleBox = new JComboBox(Locale.getAvailableLocales());
    // this line configures the combo to only commit on ENTER 
    // or selecting an item from the list
    simpleBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
    //
    // simpleBox.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
    //     Collections.EMPTY_SET);
    // just noticed the OPs edit - following indeed is easier to disable _all_ traversal
    // keys with one statement
    simpleBox.setFocusTraversalKeysEnabled(false);

    Action myAction = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.info("got it!");
            simpleBox.transferFocus();
        }

    };
    simpleBox.getActionMap().put("tab-action", myAction);
    simpleBox.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
       .put(KeyStroke.getKeyStroke("TAB"), "tab-action");