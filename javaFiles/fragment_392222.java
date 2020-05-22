private void acoesTela(){
        ActionMap am = panelPrincipal.getActionMap();
        am.put("vaiQtd", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFieldQtd.requestFocus();
                txtFieldQtd.selectAll();
            }
        });

        am.put("vaiCodigo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFieldCod.requestFocus();
                txtFieldCod.selectAll();
            }
        });

        InputMap im = panelPrincipal.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "vaiQtd");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "vaiCodigo");
    }