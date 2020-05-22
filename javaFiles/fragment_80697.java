AvdManager avdmanager;
try {
    SdkManager manager = SdkManager.createManager("path/to/android/sdk/folder", this);
    IAndroidTarget[] targets = manager.getTargets();

    avdmanager= new AvdManager(manager,this);

    avdmanager.createAvd(new File("custom/path/for/your/avd","advname"), "advname", targets[0], target[0].getSystemImages()[0].getAbiType(), null, null, null,
            false, false, false, this);

} catch (AndroidLocationException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}