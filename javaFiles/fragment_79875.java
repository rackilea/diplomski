public class DataMouseHandler extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {

        final Data data = NewPerson.createPerson(frame);
        if (data != null) {
            if ("mother".equals(Val)) {
                createAndAddDataLabel(data);
            }
        }
    }
}