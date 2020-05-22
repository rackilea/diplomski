ActionListener listener = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent ae) {

        int pos = area.getCaretPosition();
        try {
            Rectangle r = area.modelToView(pos);
            menu.show(area, r.x, r.y);
        } catch (BadLocationException ex) {
            System.out.print(ex.toString());
        }

    }
};