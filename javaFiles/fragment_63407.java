import javax.swing.*;

import java.awt.Cursor;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

public class DndExample extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DndExample());
    }

    public DndExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel dragLabel = createDndLabel();
        getContentPane().add(dragLabel);
        pack();
        setVisible(true);
    }

    private JLabel createDndLabel() {
        JLabel label = new JLabel("Drag me, please");


        DragGestureListener dragGestureListener = (dragTrigger) -> {
            dragTrigger.startDrag(new Cursor(Cursor.HAND_CURSOR), new StringSelection(label.getText()));
        };

        DragSource dragSource = DragSource.getDefaultDragSource();
        dragSource.createDefaultDragGestureRecognizer(label, DnDConstants.ACTION_COPY, dragGestureListener);

        return label;
    }
}