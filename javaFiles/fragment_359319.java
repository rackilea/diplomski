js.addMouseMotionListener(new MouseMotionAdapter() {
    @Override
        public void mouseDragged(MouseEvent e) {
        if (js.getValue() / 100 < 1) {
        emp.setPosition((float) js.getValue() / 100);
        }
    }
});


Timer timer = new Timer(100, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        js.setValue(Math.round(emp.getPosition() * 100));
    }

});

timer.start();