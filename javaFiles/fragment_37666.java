final JPasswordField pf = new JPasswordField();
    //Create OptionPane & Dialog
    JOptionPane pane = new JOptionPane(pf, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
    JDialog dialog = pane.createDialog("ENTER SUPERUSER PASSWORD");
    //Add a listener to the dialog to request focus of Password Field
    dialog.addComponentListener(new ComponentListener(){

        @Override
        public void componentShown(ComponentEvent e) {
            pf.requestFocusInWindow();
        }
        @Override public void componentHidden(ComponentEvent e) {}
        @Override public void componentResized(ComponentEvent e) {}
        @Override public void componentMoved(ComponentEvent e) {}
        });

    dialog.setVisible(true);