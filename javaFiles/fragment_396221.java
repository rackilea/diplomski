import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TestListSort {

    public TestListSort() {
        JList list = createList();
        JButton button = createButton(list);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(200, 150));

        JFrame frame = new JFrame();
        frame.add(scroll);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JButton createButton(final JList list) {
        JButton button = new JButton("Sort");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel)list.getModel();
                sortModel(model);
            }
        });
        return button;
    }

    private void sortModel(DefaultListModel model) {
        List<MyObject> list = new ArrayList<>();
        for (int i = 0; i < model.size(); i++) {
            list.add((MyObject)model.get(i));
        }
        Collections.sort(list);
        model.removeAllElements();
        for (MyObject s : list) {
            model.addElement(s);
        }
    }

    private JList createList() {
        JList list = new JList(createModel());
        return list;
    }

    private DefaultListModel createModel() {
        Random random = new Random();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < 20; i++) {
            long time = random.nextLong();
            Time timeObj = new Time(time);
            model.addElement(new MyObject("Object " + i, timeObj));
        }
        return model;

    }


    private class MyObject implements Comparable<MyObject> {

        private Time time;
        private String name;

        public MyObject(String name, Time time) {
            this.time = time;
            this.name = name;
        }

        @Override
        public int compareTo(MyObject o) {
            return (this.getTime().compareTo(o.getTime()));
        }

        public Time getTime() {
            return time;
        }

        @Override
        public String toString() {
            return name + " : " + time;
        }

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestListSort();
            }
        });
    }
}