Image tempPlaceholder = Image.createImage(
        ParametresGeneraux.SIZE_OF_REPORT_PIC_IN_PX,
        ParametresGeneraux.SIZE_OF_REPORT_PIC_IN_PX,
        ParametresGeneraux.accentColor);
Graphics gr = tempPlaceholder.getGraphics();
gr.setAntiAliased(true);
gr.setColor(ParametresGeneraux.accentColor);
gr.fillArc(0, 0, ParametresGeneraux.SIZE_OF_REPORT_PIC_IN_PX, ParametresGeneraux.SIZE_OF_REPORT_PIC_IN_PX, 0, 360);

myComponent.setIcon(tempPlaceholder);


...


//Then call this at the end of everything
Display.getInstance().callSerially(() -> {
    EncodedImage roundPlaceholder = EncodedImage.createFromImage(tempPlaceholder, true);

    final Image reportImage = URLImage.createToStorage(
                        roundPlaceholder,
                        photoFilenameInStorage,
                        currentReport.getPhotoPath(),
                        ParametresGeneraux.RESIZE_SCALE_WITH_ROUND_MASK
                );
    myComponent.setIcon(reportImage);
    myComponent.getComponentForm().repaint();
});