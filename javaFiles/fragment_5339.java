@Component(role = MavenFileFilter.class, hint = "default")
public class MyMavenFileFilter extends DefaultMavenFileFilter {

    public void copyFile(File from, File to, boolean filtering, List<FileUtils.FilterWrapper> filterWrappers, String encoding, boolean overwrite) throws MavenFilteringException {
        super.copyFile(from, to, filtering, filterWrappers, encoding, overwrite);
        // your logic of modifying the "to" file here
    }

}