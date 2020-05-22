import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class TestSplitPanels extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final TestSplitPanels tps = new TestSplitPanels();
        frame.setContentPane(tps);
        frame.pack();
        frame.setVisible(true);
    }

    public TestSplitPanels() {

        JTable jt1 = new JTable();
        JTable jt2 = new JTable();
        JTable jt3 = new JTable();

        final JScrollPane jsr1 = new JScrollPane();
        final JScrollPane jsr2 = new JScrollPane();
        final JScrollPane jsr3 = new JScrollPane();

        jsr1.setViewportView(jt1);
        jsr2.setViewportView(jt2);
        jsr3.setViewportView(jt3);

        JSplitPane jsl1 = new JSplitPane();
        JSplitPane jsl2 = new JSplitPane();

        jsl1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jsl1.setTopComponent(jsr1);
        jsl1.setBottomComponent(jsl2);
        jsl1.setResizeWeight(0.33); // <-- here

        jsl2.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jsl2.setTopComponent(jsr2);
        jsl2.setBottomComponent(jsr3);
        jsl2.setResizeWeight(0.5); // <-- here

        this.addAncestorListener(new BaseAncestorListener() {
            @Override
            public void ancestorMoved(AncestorEvent event) {
                System.out.println("jsr1 size: " + jsr1.getSize());
                System.out.println("jsr2 size: " + jsr2.getSize());
                System.out.println("jsr3 size: " + jsr3.getSize());
                System.out.println("----");
            }
        });

        setLayout(new BorderLayout());
        add(jsl1, BorderLayout.CENTER);
    }

    public static class BaseAncestorListener implements AncestorListener {

        @Override
        public void ancestorAdded(AncestorEvent event) {
        }

        @Override
        public void ancestorRemoved(AncestorEvent event) {
        }

        @Override
        public void ancestorMoved(AncestorEvent event) {
        }

    }
}