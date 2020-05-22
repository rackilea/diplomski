public class Activator extends AbstractUIPlugin {
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        IPreferenceStore ps = getPreferenceStore();
        ps.setDefault(SHOW_IMAGE, true);
    }
    public static final String SHOW_IMAGE = "showImage";
}