import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Foo extends JFrame {

    private JButton btn;

    Foo(){

        super("Foo frame");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(200,100));
        setLocationRelativeTo(null);

        btn = new JButton("Click Me");
        getContentPane().add(btn);

        validate();
        pack();
    }

    JButton getBtn() {
        return btn;
    }

    public static void main(String[] args)  {

        Foo foo = new Foo();
        Moo moo = new Moo();
        foo.getBtn().addMouseListener(moo.getMouseListener());
        foo.setVisible(true);
    }
}

class Moo {

    Moo() {}

    MouseListener getMouseListener() {

        return new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                System.out.println("Mouse pressed ! ");
            }
        };
    }
}