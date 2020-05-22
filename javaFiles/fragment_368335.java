/**
     * @author user592704
     */

    class ShapePanel extends JPanel
    {

    private Color[] colors;
    private Vector<MyCircleColorActionListener> myCircleColorActionListeners=new Vector<MyCircleColorActionListener>();

    public static final int OVAL_COLOR=0;
    public static final int FILL_OVAL_COLOR=1;


        @Override
    public void paintComponent (Graphics g)
    {
        this.myPaint(g);
    }

        private void myPaint(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(this.getColor()[ShapePanel.OVAL_COLOR]);
            g.drawOval(0,0, 20, 20);
            g.setColor(this.getColor()[ShapePanel.FILL_OVAL_COLOR]);
            g.fillOval(0, 0, 15, 15);
        }

        private Color[] getColor() {
            return colors;
        }

        private void setColor(Color[] colors) {
            this.colors = colors;
            this.repaint();
            this.invokeObserver();
        }

        private void invokeObserver()
        {
            for(MyCircleColorActionListener myCircleColorActionListener:this.myCircleColorActionListeners)
            {
               myCircleColorActionListener.onColorChanged();
            }
        }
        public void addMyCircleColorActionListener(MyCircleColorActionListener myCircleColorActionListener){this.myCircleColorActionListeners.add(myCircleColorActionListener);}



        private JPanel getPanel(){return this;}
    }

    public interface MyCircleColorActionListener
    {
      void onColorChanged();
    }

    /**
     * Some another object
     */
    class MyAnotherClass extends JPanel implements MyCircleColorActionListener
    {
        private ShapePanel shapePanel=new ShapePanel();
        private JButton testButton=new JButton("set red");

        MyAnotherClass()
        {
            this.setLayout(new FlowLayout());

            testButton.addMouseListener(new MouseAdapter(){

                @Override
                public void mouseClicked(MouseEvent e) {

                    Color [] colors=new Color[2];
                    colors[ShapePanel.OVAL_COLOR]=Color.green;
                    colors[ShapePanel.FILL_OVAL_COLOR]=Color.red;
                    getShapePanel().setColor(colors);
                }
            });

            this.add(testButton);
            this.shapePanel.addMyCircleColorActionListener(this);
        }

        private ShapePanel getShapePanel(){return this.shapePanel;}

        public void onColorChanged() {
            System.out.println("Color was changed");
        }

    }