public class RobolectricGradleTestRunner extends RobolectricTestRunner {
    public RobolectricGradleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        String pwd = YourApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String root = pwd + "../../../src/main/";

        return new AndroidManifest(
                Fs.fileFromPath(root + "AndroidManifest.xml"),
                Fs.fileFromPath(root + "res"),
                Fs.fileFromPath(root + "assets"));
    }
}