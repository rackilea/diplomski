final Popup p = PopupFactory.getSharedInstance().getPopup(myComponent, new JLabel("Here is my popup!"), x, y);
    p.show();
    // create a timer to hide the popup later
    Timer t = new Timer(5000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            p.hide();

        }
    });
    t.setRepeats(false);
    t.start();