import java.util.List;

public class CtrlNode {

    private String name;
    private boolean status;
    private CtrlNode parent;
    private List<CtrlNode> kids;

    public CtrlNode(String name, boolean status, CtrlNode parent, List<CtrlNode> kids) {
        super();
        this.name = name;
        this.status = status;
        this.parent = parent;
        this.kids = kids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CtrlNode getParent() {
        return parent;
    }

    public void setParent(CtrlNode parent) {
        this.parent = parent;
    }

    public List<CtrlNode> getKids() {
        return kids;
    }

    public void setKids(List<CtrlNode> kids) {
        this.kids = kids;
    }

    public void off() {
        recurOff(this);
    }

    private void recurOff(CtrlNode node) {
        if (node != null && node.getStatus()) {
            node.setStatus(false);
            for (CtrlNode kid : node.getKids()) {
                recurOff(kid);
            }
        }
    }

    public void on() {
        if(!this.getStatus() && this.getParent().getStatus()) {
            this.setStatus(true);
        }
    }

}