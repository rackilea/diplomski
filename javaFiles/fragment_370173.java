public class Global extends GlobalSettings {

    @Override
    public void beforeStart(Application app) {
        // TODO Auto-generated method stub
        super.beforeStart(app);

        String libopencv_java = "/Users/yoonjechoi/git/myFirstApp/target/native_libraries/64bits/libopencv_java246.jnilib";
        System.load(libopencv_java);
    }
}