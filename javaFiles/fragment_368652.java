public void itemStateChanged(ItemEvent e){
    if (hmo.isSelected()) {
        total = 200;
        if(dental.isSelected()) {
            total += 75;
        }
        if(visual.isSelected()) {        
            total += 20;
        }
        t1.setText(String.valueOf(total));
    }
    else if(ppo.isSelected()) {
        total = 600;
        if(dental.isSelected()) {
            total += 75;
        }
        if(visual.isSelected()) {
            total += 20;
        }
        t1.setText(String.valueOf(total));
    }
    else {    // In case you later use grp.clearSelection();
        total = 0;
        t1.setText("");
    }
}