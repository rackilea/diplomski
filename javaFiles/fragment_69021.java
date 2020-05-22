public class PanelDraggable extends JPanel {

    public PanelDraggable (..., final TableManagement tblManagement) {
        .
        .
        .
        addMouseListener(new MouseAdapter() {
            @Override
            public void (MouseEvent e) {
                tblManagement.removeTable();
            }
        });

    }
}