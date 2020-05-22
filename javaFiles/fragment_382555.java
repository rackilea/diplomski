public void addTextArea() {

    WorkDescription wd = new WorkDescription();

    panel.remove(panel_buttons); 
    panel.add(wd);

    if(addedWorks < 4 ) {       

        addedWorks++;
        panel.add(panel_buttons);

    }

    panel.revalidate();
    panel.repaint();
}