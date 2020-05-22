box.addActionListener(new ActionListener(){
    public void actionPerfomed(ActionEvent e) {
        String s = (String)box.getSelectedItem();
        switch(s) {
            case "Convertion": new conveter(); break;
            case "Adv.Calculator": ...
        }
    }
});