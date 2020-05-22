ImageIcon icon = new ImageIcon();
    JButton btn = new JButton(icon);

    // set the Image Observer of the ImageIcon
    icon.setImageObserver(btn);

    ...

    // get Image Observer back from ImageIcon
    JButton observer = (JButton) icon.getImageObserver();

    if (observer == btn) {
        System.out.println("We got the JButton from ImageIcon");
    }