package so1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {

    private static final long serialVersionUID = 3000003489937872937L;

    public class Data {
        public void doSomethings() {
            System.out.println("toto");
        }
    }

    public class Board extends JLabel {

        private static final long serialVersionUID = 7362684018638848838L;
        private Data data = new Data();

    }

    private Board board;

    public Window() {
        board = new Board();
        add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        Window ex = new Window();
        ex.setVisible(true);
        ex.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                ex.board.data.doSomethings();
            }
        });
    }
}