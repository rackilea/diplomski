try {
    File filePath = "/mnt/sdcard/vmphoto.jpg"; //This is imagefile path in your change it acc. to your requirement.
    share("facebook",filePath.toString());

}
catch(Exception e) {
           //exception occur might your app like gmail , facebook etc not installed or not working correctly.
}