import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNodeDTO {

    /** The id. */
    private String id;

    /** The title. */
    private String title;

    /** The children. */
    private List<TreeNodeDTO> children;

    private List<TreeNodeDTO> recursiveSearch(String search) {
        if ( getTitle().equalsIgnoreCase( search ) ) {
            return Arrays.asList(this);
        }
        ArrayList<TreeNodeDTO> resultList = new ArrayList<>();
        for (TreeNodeDTO child : getChildren()) {
            resultList.addAll(child.recursiveSearch(search));
        }
        return resultList;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<TreeNodeDTO> getChildren() {
        return children;
    }

}