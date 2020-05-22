public class Pages {
public static List<Page> getPath(Page from, Page to) {
    if (from == null || to == null) throw new IllegalArgumentException();

    List<Page> path = new ArrayList<Page>();
    Page page=to.getParent();
    Page last=from.getParent();
    // I'm assuming getPath() can be null occassionaly and is a String
    String lastPath;
    if(last!=null && (lastPath=last.getPath())!=null){
    // The assignment above is an acceptable one, as it saves a nested if statement
        // traverse your path
        while(page!=null && page.getPath()!=null && !(page.getPath().equals(lastPath))) {
            path.add(page);
            page=page.getParent();
        }
    }
    Collections.reverse(path);
    return path.contains(from) ? path : null;
}