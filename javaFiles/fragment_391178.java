import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeNode extends Node {

private List<Attribute> attributes;
private Set<Integer> splittedAttrs;
private int level;
private String displayPrefix;
private Object children;
private double threshhold;

public TreeNode(List<Record> dataSet, int labelIndex,
        List<Attribute> attributes, int level, double threshhold) {
    super(dataSet, labelIndex);
    this.attributes = attributes;
    splittedAttrs = new HashSet<Integer>();
    this.level = level;
    this.displayPrefix = "";
    this.children = null;
    this.threshhold = threshhold;
}

public static void main(String[] args) {
    Node node = new TreeNode(new ArrayList<Record>(), 1,
            new ArrayList<Attribute>(), 1, 1.1);

}