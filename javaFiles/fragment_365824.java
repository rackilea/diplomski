public class TestRoundButton {

    public static void main(String[] args) {
        new TestRoundButton();
    }

    public TestRoundButton() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.RED);
                frame.setLayout(new GridBagLayout());
                frame.add(new RoundButton(":)"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class RoundButton extends JPanel {

        ActionListener actionListener;     // Post action events to listeners
        String label;                      // The Button's text
        protected boolean pressed = false; // true if the button is detented.

        private MouseListener listener;

        /**
         * Constructs a RoundButton with no label.
         */
        public RoundButton() {
            this("");
        }

        @Override
        public void addNotify() {
            super.addNotify();
            if (listener == null) {
                listener = new MouseHandler();
                addMouseListener(listener);
            }
        }

        @Override
        public void removeNotify() {
            removeMouseListener(listener);
            super.removeNotify();
        }

        /**
         * Constructs a RoundButton with the specified label.
         *
         * @param label the label of the button
         */
        public RoundButton(String label) {
            this.label = label;
            //...
            setOpaque(false);
            // Use a mouse listener instead
//            enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        }

        /**
         * gets the label
         *
         * @see setLabel
         */
        public String getLabel() {
            return label;
        }

        /**
         * sets the label
         *
         * @see getLabel
         */
        public void setLabel(String label) {
            this.label = label;
            invalidate();
            repaint();
        }

        /**
         * paints the RoundButton
         */
        // Prefer paintComponent over paint...
        @Override
        protected void paintComponent(Graphics g) {
            // YOU MUST CALL super.paintXxx THERE IS NO EXCUSE NOT TO, EVER!!
            super.paintComponent(g);
            int s = Math.min(getSize().width - 1, getSize().height - 1);

            Graphics2D g2d = (Graphics2D) g.create();
            // paint the interior of the button
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

            Color highlight = getBackground();
            if (pressed) {
                highlight = highlight.darker();
            }
            Color darklight = highlight.darker();

            LinearGradientPaint lgp = new LinearGradientPaint(
                    new Point(0, 0),
                    new Point(0, s),
                    new float[]{0, 1f},
                    new Color[]{highlight, darklight});

            Ellipse2D shape = new Ellipse2D.Float(0, 0, s, s);
            g2d.setPaint(lgp);
            g2d.fill(shape);

            // draw the perimeter of the button
            g2d.setColor(getBackground().darker().darker().darker());
            g2d.draw(shape);
            // draw the label centered in the button
            Font f = getFont();
            if (f != null) {
                FontMetrics fm = getFontMetrics(getFont());
                g2d.setColor(getForeground());
                g2d.drawString(label,
                        s / 2 - fm.stringWidth(label) / 2,
                        s / 2 + fm.getMaxDescent());
            }
            g2d.dispose();
        }

        /**
         * The preferred size of the button.
         */
        public Dimension getPreferredSize() {
            Font f = getFont();
            if (f != null) {
                FontMetrics fm = getFontMetrics(getFont());
                int max = Math.max(fm.stringWidth(label) + 40, fm.getHeight() + 40);
                return new Dimension(max, max);
            } else {
                return new Dimension(100, 100);
            }
        }

        /**
         * The minimum size of the button.
         */
        public Dimension getMinimumSize() {
            return new Dimension(100, 100);
        }

        /**
         * Adds the specified action listener to receive action events from this
         * button.
         *
         * @param listener the action listener
         */
        public void addActionListener(ActionListener listener) {
//            actionListener = AWTEventMulticaster.add(actionListener, listener);
//            enableEvents(AWTEvent.MOUSE_EVENT_MASK);
            listenerList.add(ActionListener.class, listener);
        }

        /**
         * Removes the specified action listener so it no longer receives action
         * events from this button.
         *
         * @param listener the action listener
         */
        public void removeActionListener(ActionListener listener) {
//            actionListener = AWTEventMulticaster.remove(actionListener, listener);
            listenerList.add(ActionListener.class, listener);
        }

        /**
         * Determine if click was inside round button.
         */
        public boolean contains(int x, int y) {
            // This needs to work more on the actual painted shape...
            int mx = getSize().width / 2;
            int my = getSize().height / 2;
            return (((mx - x) * (mx - x) + (my - y) * (my - y)) <= mx * mx);
        }
        /**
         * Paints the button and distribute an action event to all listeners.
         */
//        public void processMouseEvent(MouseEvent e) {
//            @SuppressWarnings("unused")
//            Graphics g;
//            switch (e.getID()) {
//                case MouseEvent.MOUSE_PRESSED:
//                    // render myself inverted....
//                    pressed = true;
//
//                    // Repaint might flicker a bit. To avoid this, you can use
//                    // double buffering (see the Gauge example).
//                    repaint();
//                    break;
//                case MouseEvent.MOUSE_RELEASED:
//                    if (actionListener != null) {
//                        actionListener.actionPerformed(new ActionEvent(
//                                this, ActionEvent.ACTION_PERFORMED, label));
//                    }
//                    // render myself normal again
//                    if (pressed == true) {
//                        pressed = false;
//
//                        // Repaint might flicker a bit. To avoid this, you can use
//                        // double buffering (see the Gauge example).
//                        repaint();
//                    }
//                    break;
//                case MouseEvent.MOUSE_ENTERED:
//
//                    break;
//                case MouseEvent.MOUSE_EXITED:
//                    if (pressed == true) {
//                        // Cancel! Don't send action event.
//                        pressed = false;
//
//                        // Repaint might flicker a bit. To avoid this, you can use
//                        // double buffering (see the Gauge example).
//                        repaint();
//
//                        // Note: for a more complete button implementation,
//                        // you wouldn't want to cancel at this point, but
//                        // rather detect when the mouse re-entered, and
//                        // re-highlight the button. There are a few state
//                        // issues that that you need to handle, which we leave
//                        // this an an excercise for the reader (I always
//                        // wanted to say that!)
//                    }
//                    break;
//            }
//            super.processMouseEvent(e);
//        }

        public class MouseHandler extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                repaint();
            }

        }

    }
}