public static boolean takePhoto() {
    if(camera != null) {
        camera.takePicture(null, null, pictureTakenHandler);
        return true;
    }
    else
        return false;
}