List<DigitalPhoto> photoes = new ArrayList<DigitalPhoto>(); 
do
    {
    DigitalPhoto photo = new DigitalPhoto();
    heightString = JOptionPane.showInputDialog('Please enter height');
    photo .setHeight = double.parseDouble(heightString);
    heightString = JOptionPane.showInputDialog('Please enter width');
    photo .setWidth = double.parseDouble(widthtString);
    photos.add(photo)
    continueQuestion = JOptionPane.showInputDialog('Height: ' + class[i].getHeight + '\n\lWidth: ' + class[i].getWidth + '\n\l Resolution: ' + class[i].getResolution + '\n\lCompression Ratio: ' + class[i].getCompression + '\n\lRequired Storage: ' + class[i].calcStorage() + '\n\lPrice of Scanned Photo: ' + class[i].getCost() + 'Please enter "Y" to try again or anything but "Y" to accept values.')
    } while {cont.equals("Y")};