private static Cell addSizedImage(Table table, Image image){
    return table.add(image).size(image.getWidth(), image.getHeight());
}

private static Table generateBlock (Image... imgs){
    if (imgs.length != 8) throw new UnsupportedOperationException("Must have 8 images");
    Table root = new Table();
    addSizedImage(root, imgs[0]).colspan(3);

    Table innerTable = new Table();
    addSizedImage(innerTable, imgs[1]);
    addSizedImage(innerTable, imgs[2]).row();
    addSizedImage(innerTable, imgs[3]);
    addSizedImage(innerTable, imgs[4]);

    root.add(innerTable).row();

    addSizedImage(root, imgs[5]);
    addSizedImage(root, imgs[6]);
    addSizedImage(root, imgs[7]);

    return root;
}

private Table createImagesUI (){
    Table root = new Table();
    root.setFillParent(true);
    root.bottom();

    root.add(generateBlock(image1, image2, image3, image4, image5, image6, image7, image8)).expandX();
    root.add(generateBlock(image9, image10, image11, image12, image13, image14, image15, image16)).expandX();

    return root;
}