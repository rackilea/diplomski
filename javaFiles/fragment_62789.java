public void actionPerformed(ActionEvent e) {
    int choice;

    if (currImageBlock == null) {
        currImageBlock = imageBlock1;
    } else if (currImageBlock == imageBlock1) {
        currImageBlock = imageBlock2;
    } else if (currImageBlock == imageBlock2) {
        currImageBlock = imageBlock3;
    } else if (currImageBlock == imageBlock3) {
        currImageBlock = imageBlock1;
    } 

    if (e.getSource().equals(animalOption)) { //add DVD Button
        choice = selectAnimal();

        if (choice == 1) {
            currImageBlock.setIcon(bear);
        } else if (choice == 2) {
            currImageBlock.setIcon(tiger);
        } else if (choice == 3) {
            currImageBlock.setIcon(lion);
        }
    }
}