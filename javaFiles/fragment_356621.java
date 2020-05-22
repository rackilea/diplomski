import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Counter extends JFrame implements ActionListener {

    private TextField[] items = new TextField[6];
    private JButton btnSort, btnClear, btnReset;
    private TextField tmp;
    private Label status;
    private JLabel cntLabel;

    private int pauseInterval = 100;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        Counter f = new Counter();
        f.init();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public Counter() {
//      init();
    }

    public void init() {
        setTitle("Sorting Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440, 200);
        JPanel jp = new JPanel(new BorderLayout());
        jp.setPreferredSize(new Dimension(440, 200));
        jp.setBackground(Color.white);

        JPanel itemPanel = new JPanel(new FlowLayout());
        itemPanel.setBackground(Color.white);
        for (int i = 0; i < items.length; i++) {
            items[i] = new TextField(3);
            items[i].setPreferredSize(new Dimension(30, 40));
            itemPanel.add(items[i]);
        }

        initItems();

        itemPanel.add(new Label("Temp:"));
        tmp = new TextField(4);
        tmp.setPreferredSize(new Dimension(30, 40));
        tmp.setEditable(false);
        itemPanel.add(tmp);
        itemPanel.add(cntLabel).setPreferredSize(new Dimension(100, 65));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        btnSort = new JButton("Sort");
        btnReset = new JButton("Reset");
        btnClear = new JButton("Clear");
        btnSort.addActionListener(this);
        btnClear.addActionListener(this);
        btnReset.addActionListener(this);
        buttonPanel.add(btnSort);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnReset);

        status = new Label("Wating ... ");
        status.setPreferredSize(new Dimension(380, 40));
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Color.white);
        statusPanel.add(status, BorderLayout.SOUTH);

        jp.add(itemPanel, BorderLayout.NORTH);
        jp.add(buttonPanel, BorderLayout.CENTER);
        jp.add(statusPanel, BorderLayout.SOUTH);

        getContentPane().add(jp);
    }

    private void initItems() {
        for (int i = 0; i < items.length; i++) {
            items[i].setText((String.valueOf((int) (Math.random() * 100))));
        }
//      if(null!=swapLabel)
//          swapLabel.setText("");
        cntLabel = new JLabel("0");
    }

    private void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            showStatus(e.toString());
        }
    }

    private void assign(TextField to, TextField from) {
        Color tobg = to.getBackground();
        to.setBackground(Color.green);
        pause(pauseInterval);
        to.setText(from.getText());
        pause(pauseInterval);
        to.setBackground(tobg);
    }

    private void swapItems(TextField t1, TextField t2) {
        assign(tmp, t1);
        assign(t1, t2);
        assign(t2, tmp);
    }

    private boolean greaterThan(TextField t1, TextField t2) {
        boolean greater;
        Color t1bg = t1.getBackground();
        Color t2bg = t2.getBackground();
        t1.setBackground(Color.cyan);
        t2.setBackground(Color.cyan);
        pause(pauseInterval);
        greater = Integer.parseInt(t1.getText()) < Integer.parseInt(t2.getText());
        pause(pauseInterval);
        t1.setBackground(t1bg);
        t2.setBackground(t2bg);
        return greater;
    }

    private void bubbleSort() {
        int currentCount = 0;
        int n = 0;
        showStatus("Sorting ...");
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < items.length - 1; i++) {
                if (greaterThan(items[i], items[i + 1])) {
                    swapItems(items[i], items[i + 1]);
                    swap = true;
                    currentCount++;
                }
            } // for
        } // while
        showStatus("Sort complete : Swap count = " + currentCount);
    } // bubbleSort

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
        case "Clear":
            for (int i = 0; i < items.length; i++) {
                items[i].setText("");
            }
            cntLabel = new JLabel("0");
            break;
        case "Sort":
            bubbleSort();
            break;
        case "Reset":
            initItems();
            break;
        default:
            showStatus("Unrecognised button: " + e.toString());
        }
    }

    private void showStatus(String s) {
        status.setText(s);
    }

}