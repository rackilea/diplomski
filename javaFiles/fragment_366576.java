import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                SplitButton btn = new SplitButton();
                btn.setText("This is a split button");

                JFrame frame = new JFrame("Testing");
                frame.setLayout(new GridBagLayout());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(btn);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SplitButton extends JButton {

        private int separatorSpacing = 4;
        private int splitWidth = 30;
        private int arrowSize = 8;

        private Rectangle splitRectangle;
        private Color arrowColor = Color.BLACK;
        private Color disabledArrowColor = Color.GRAY;
        private Image image;

        public SplitButton() {
            super();
        }

        @Override
        public Insets getInsets() {
            Insets insets = (Insets) super.getInsets().clone();
            insets.right += splitWidth;
            return insets;
        }

        @Override
        public Insets getInsets(Insets insets) {
            Insets insets1 = getInsets();
            insets.left = insets1.left;
            insets.right = insets1.right;
            insets.bottom = insets1.bottom;
            insets.top = insets1.top;
            return insets1;
        }

        /**
         * Returns the separatorSpacing. Separator spacing is the space above and
         * below the separator( the line drawn when you hover your mouse over the
         * split part of the button).
         *
         * @return separatorSpacingimage = null; //to repaint the image with the new
         * size
         */
        public int getSeparatorSpacing() {
            return separatorSpacing;
        }

        /**
         * Sets the separatorSpacing.Separator spacing is the space above and below
         * the separator( the line drawn when you hover your mouse over the split
         * part of the button).
         *
         * @param spacing
         */
        public void setSeparatorSpacing(int spacing) {
            if (spacing != separatorSpacing && spacing >= 0) {
                int old = separatorSpacing;
                this.separatorSpacing = spacing;
                image = null;
                firePropertyChange("separatorSpacing", old, separatorSpacing);
                revalidate();
                repaint();
            }
        }

        /**
         * Gets the color of the arrow.
         *
         * @return arrowColor
         */
        public Color getArrowColor() {
            return arrowColor;
        }

        /**
         * Set the arrow color.
         *
         * @param color
         */
        public void setArrowColor(Color color) {
            if (arrowColor != color) {
                Color old = arrowColor;
                this.arrowColor = color;
                image = null;
                firePropertyChange("arrowColor", old, arrowColor);
                repaint();
            }
        }

        /**
         * gets the disabled arrow color
         *
         * @return disabledArrowColor color of the arrow if no popup attached.
         */
        public Color getDisabledArrowColor() {
            return disabledArrowColor;
        }

        /**
         * sets the disabled arrow color
         *
         * @param color color of the arrow if no popup attached.
         */
        public void setDisabledArrowColor(Color color) {
            if (disabledArrowColor != color) {
                Color old = disabledArrowColor;
                this.disabledArrowColor = color;
                image = null; //to repaint the image with the new color
                firePropertyChange("disabledArrowColor", old, disabledArrowColor);
            }
        }

        /**
         * Splitwidth is the width of the split part of the button.
         *
         * @return splitWidth
         */
        public int getSplitWidth() {
            return splitWidth;
        }

        /**
         * Splitwidth is the width of the split part of the button.
         *
         * @param width
         */
        public void setSplitWidth(int width) {
            if (splitWidth != width) {
                int old = splitWidth;
                this.splitWidth = width;
                firePropertyChange("splitWidth", old, splitWidth);
                revalidate();
                repaint();
            }
        }

        /**
         * gets the size of the arrow.
         *
         * @return size of the arrow
         */
        public int getArrowSize() {
            return arrowSize;
        }

        /**
         * sets the size of the arrow
         *
         * @param size
         */
        public void setArrowSize(int size) {
            if (arrowSize != size) {
                int old = arrowSize;
                this.arrowSize = size;
                image = null; //to repaint the image with the new size
                firePropertyChange("setArrowSize", old, arrowSize);
                revalidate();
                repaint();
            }
        }

        /**
         * Gets the image to be drawn in the split part. If no is set, a new image
         * is created with the triangle.
         *
         * @return image
         */
        public Image getImage() {
            if (image == null) {
                Graphics2D g = null;
                BufferedImage img = new BufferedImage(arrowSize, arrowSize, BufferedImage.TYPE_INT_RGB);
                g = (Graphics2D) img.createGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, img.getWidth(), img.getHeight());
                g.setColor(isEnabled() ? arrowColor : disabledArrowColor);
                //this creates a triangle facing right >
                g.fillPolygon(new int[]{0, 0, arrowSize / 2}, new int[]{0, arrowSize, arrowSize / 2}, 3);
                g.dispose();
                //rotate it to face downwards
                img = rotate(img, 90);
                BufferedImage dimg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
                g = (Graphics2D) dimg.createGraphics();
                g.setComposite(AlphaComposite.Src);
                g.drawImage(img, null, 0, 0);
                g.dispose();
                for (int i = 0; i < dimg.getHeight(); i++) {
                    for (int j = 0; j < dimg.getWidth(); j++) {
                        if (dimg.getRGB(j, i) == Color.WHITE.getRGB()) {
                            dimg.setRGB(j, i, 0x8F1C1C);
                        }
                    }
                }

                image = Toolkit.getDefaultToolkit().createImage(dimg.getSource());
            }
            return image;
        }

        /**
         *
         * @param g
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Graphics gClone = g.create();//EDIT: Hervé Guillaume
            Color oldColor = g.getColor();
            splitRectangle = new Rectangle(getWidth() - splitWidth, 0, splitWidth, getHeight());
            g.translate(splitRectangle.x, splitRectangle.y);
            int mh = getHeight() / 2;
            int mw = splitWidth / 2;
            g.drawImage(getImage(), mw - arrowSize / 2, mh + 2 - arrowSize / 2, null);
            if (getModel().isRollover() || isFocusable()) {
                g.setColor(UIManager.getLookAndFeelDefaults().getColor("Button.background"));
                g.drawLine(1, separatorSpacing + 2, 1, getHeight() - separatorSpacing - 2);
                g.setColor(UIManager.getLookAndFeelDefaults().getColor("Button.shadow"));
                g.drawLine(2, separatorSpacing + 2, 2, getHeight() - separatorSpacing - 2);
            }
            g.setColor(oldColor);
            g.translate(-splitRectangle.x, -splitRectangle.y);
        }

        /**
         * Rotates the given image with the specified angle.
         *
         * @param img image to rotate
         * @param angle angle of rotation
         * @return rotated image
         */
        private BufferedImage rotate(BufferedImage img, int angle) {
            int w = img.getWidth();
            int h = img.getHeight();
            BufferedImage dimg = dimg = new BufferedImage(w, h, img.getType());
            Graphics2D g = dimg.createGraphics();
            g.rotate(Math.toRadians(angle), w / 2, h / 2);
            g.drawImage(img, null, 0, 0);
            return dimg;
        }

    }

}