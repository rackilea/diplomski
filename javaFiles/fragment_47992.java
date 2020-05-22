if(!Magnification.INSTANCE.MagSetImageScalingCallback(hwndMag, new MagImageScalingCallback() {

    public boolean MagImageScalingCallback(HWND hwnd, Pointer srcdata,
            MAGIMAGEHEADER.ByValue srcheader, Pointer destdata,
            MAGIMAGEHEADER.ByValue destheader, RectByValue source, RectByValue clipped, HRGN dirty) {
        image.setRGB(0, 0, srcheader.width, srcheader.height, srcdata.getIntArray(0, srcheader.width * srcheader.height ), 0, srcheader.width);
        return true;
    }
})){
    System.err.println("Error occured while setting callback");
    System.exit(0);
}