import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class DesktopTest extends JFrame {

private JDesktopPane desktop;
private JPanel background;
private JInternalFrame firstFrame;
private JInternalFrame secondFrame;

public DesktopTest() {
    super("DesktopTest");

    desktop = new JDesktopPane();
    setContentPane(desktop);

    background = new JPanel(new BorderLayout());
    JToolBar toolbar = new JToolBar();
    toolbar.add(new AbstractAction("1") {

        public void actionPerformed(ActionEvent actionEvent) {
            firstFrame.setVisible(true);
        }
    });

    toolbar.add(new AbstractAction("2") {

        public void actionPerformed(ActionEvent actionEvent) {
            secondFrame.setVisible(true);
        }
    });
    AddPanel addPanel = new AddPanel();
    background.add(addPanel, BorderLayout.CENTER);
    background.add(toolbar, BorderLayout.SOUTH);
    addComponentListener(new ComponentAdapter() {

        public void componentResized(ComponentEvent componentEvent) {
            background.setSize(desktop.getSize());
            background.revalidate();
            background.repaint();
        }

        public void componentShown(ComponentEvent componentEvent) {
            background.setSize(desktop.getSize());
            background.revalidate();
            background.repaint();
        }
    });
    desktop.add(background);

    firstFrame = new TermFrame("First Term", "Update First Term: ", addPanel) {

        protected int getValue() {
            return addPanel.getFirst();
        }

        protected void update(int value) {
            addPanel.setFirst(value);
        }
    };
    firstFrame.pack();
    firstFrame.setBounds(10, 10, 200, 150);
    desktop.add(firstFrame);

    secondFrame = new TermFrame("Second Term", "Update Second Term: ", addPanel){

        protected int getValue() {
            return addPanel.getSecond();
        }

        protected void update(int value) {
            addPanel.setSecond(value);
        }
    };
    secondFrame.pack();
    secondFrame.setBounds(200, 200, 200, 150);
    desktop.add(secondFrame);

}

public static void main(String[] args) {
    JFrame f = new DesktopTest();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400, 400);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
}

static class AddPanel extends JPanel {
    private JLabel first;
    private JLabel second;
    private JLabel result;

    public AddPanel() {
        first = new JLabel("0");
        second = new JLabel("0");
        result = new JLabel("0");

        Box vertical = Box.createVerticalBox();
        vertical.add(Box.createVerticalGlue());
        Box horizontal = Box.createHorizontalBox();
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(first);
        horizontal.add(new JLabel("+"));
        horizontal.add(second);
        horizontal.add(new JLabel("="));
        horizontal.add(result);
        horizontal.add(Box.createHorizontalGlue());
        vertical.add(horizontal);
        vertical.add(Box.createVerticalGlue());

        setLayout(new BorderLayout());
        add(vertical, BorderLayout.CENTER);
    }

    public void setFirst(int i) {
        first.setText(Integer.toString(i));
        updateResult();
    }

    public int getFirst() {
        return Integer.parseInt(first.getText());
    }

    public void setSecond(int j) {
        second.setText(Integer.toString(j));
        updateResult();
    }

    public int getSecond() {
        return Integer.parseInt(second.getText());
    }

    private void updateResult() {
        int i = Integer.parseInt(first.getText());
        int j = Integer.parseInt(second.getText());
        result.setText(Integer.toString(i + j));
        revalidate();
    }
}

static abstract class TermFrame extends JInternalFrame {

    protected AddPanel addPanel;
    private JFormattedTextField termField;

    public TermFrame(String title, String message, AddPanel addPanel) {
        super(title, true, true, true);
        this.addPanel = addPanel;
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(0);
        termField = new JFormattedTextField(format);
        termField.setColumns(3);
        termField.setValue(getValue());

        JPanel content = new JPanel(new FlowLayout());
        content.add(new JLabel(message));
        content.add(termField);
        JButton apply = new JButton("apply");
        apply.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                Integer value = Integer.parseInt(termField.getText());
                update(value);
            }
        });
        content.add(apply);
        setContentPane(content);

        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
    }

    protected abstract int getValue();

    protected abstract void update(int value);


}
}