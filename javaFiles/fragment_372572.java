@Component
public class JspConfig implements TomcatContextCustomizer {
    @Override
    public void customize(Context context) {
        JspPropertyGroup pg = new JspPropertyGroup();
        pg.addUrlPattern("/*");
        pg.setPageEncoding("UTF-8");
        pg.setTrimWhitespace("true");
        ArrayList<JspPropertyGroupDescriptor> pgs = new ArrayList<>();
        pgs.add(new JspPropertyGroupDescriptorImpl(pg));
        context.setJspConfigDescriptor(new JspConfigDescriptorImpl(pgs, new ArrayList<TaglibDescriptor>()));
    }
}