import java.awt.*;
    import java.awt.event.*;

    public class test extends Frame implements ActionListener   {
        Button b1;
        Label l1;
        static Frame f1,f2;

        public test()   {
            Panel p1 = new Panel();
            p1.add ( b1 = new Button("click") );
            p1.setLayout (new FlowLayout (FlowLayout.CENTER) );
            add(p1);

            b1.addActionListener(this);
            addWindowListener ( new WindowAdapter() {
                                    public void windowClosing (WindowEvent we)  {
                                        System.exit(0);
                                    }
                                }
                               );
        }

        public test(int i)  {
            Panel p1 = new Panel();
            p1.add(l1 = new Label("new"));
            p1.setLayout (new FlowLayout (FlowLayout.CENTER));
            add(p1);

            addWindowListener ( new WindowAdapter() {
                                    public void windowClosing (WindowEvent we)  {
                                        System.exit(0);
                                    }
                                }
                               );
        }

        public void actionPerformed(ActionEvent ae) {
            String s = ae.getActionCommand();
            if (ae.getSource() instanceof Button)   {
                if (s.equals("click"))  {
                    frame_invisible();
                    f2 = new test(10);
                    f2.setVisible(true);
                    f2.setSize(400,400);
                }
            }
        }

        public void frame_invisible()   {
            f1.setVisible(false);
        }

        public static void main (String[] args) {
            f1 = new test();
            f1.setVisible(true);
            f1.setSize(400,400);
        }
    }