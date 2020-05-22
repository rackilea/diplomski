public class DataMouseHandler extends MouseAdapter {

    private NewFamilyTree tree;

    public DataMouseHandler(NewFamilyTree tree) {
        this.tree = tree;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        final Data data = NewPerson.createPerson(frame);
        if (data != null) {
            if ("mother".equals(Val)) {
                tree.createAndAddDataLabel(data);
            }
        }
    }
}