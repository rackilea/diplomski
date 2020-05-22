import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class View extends JFrame {

    private JPanel jpanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new View();

            }
        });
    }

    public View() {
        this.setBounds(0, 0, 500, 500);
        this.setLayout(new BorderLayout());

        jpanel = new JPanel();
        jpanel.setBackground(Color.WHITE);
        this.add(jpanel, BorderLayout.CENTER);

        Model model = new Model(100, 100, 100, 100);
        paintModel(model);

        this.setVisible(true);
    }

    public void paintModel(Model model) {
        jpanel.add(new ModelView(model));
        jpanel.validate();
        jpanel.repaint();
    }

    public class ModelView extends JComponent {

        private Model model;

        public ModelView(Model model) {
            super();
            setBorder(new LineBorder(Color.RED));
            this.model = model;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(model.xPos + model.width, model.yPos + model.height);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.fillOval(model.xPos, model.yPos, model.width, model.height);
        }
    }

    public class Model {

        public int xPos;
        public int yPos;
        public int height;
        public int width;

        public Model(int xPos, int yPos, int height, int width) {
            super();
            this.xPos = xPos;
            this.yPos = yPos;
            this.height = height;
            this.width = width;
        }
    }
}