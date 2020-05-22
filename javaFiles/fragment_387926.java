public class SSCCE extends JPanel {

    enum markerColor {
        red, green, none
    };

    markerColor grid [][];
    int gridSize = 29;
    int x0 = 0;
    int y0=0;
    int step = 1;
    Graphics graph;
    public SSCCE() {
        grid = new markerColor[29][29];
        for(int i = 0; i<29;i++)
            for(int j = 0; j<29;j++)
                grid[i][j] = markerColor.none;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX(), y = e.getY();
                x-=x0; y-=y0;

                int X = x/step, Y = y/step;

                //Changed here
                if(X>=gridSize || Y>=gridSize || X < 0 || Y < 0) return;

                placeMarker(X,Y, markerColor.green);
                grid[X][Y] = markerColor.green;

                //Call repaint in the mouse click 
                repaint();
            }
        });
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int gridSize = Math.min(width,height);
        step = gridSize/29;
        gridSize = step*29;
        x0 = (width-gridSize)/2;
        y0 = (height-gridSize)/2;
        graph = g;

        graph.setPaintMode();
        g.setColor(Color.black);
        for(int i = 1, pointer=step; i<=28; i++, pointer+=step) {
            g.drawLine(x0+pointer,y0,x0+pointer,y0+gridSize);
            g.drawLine(x0,y0+pointer,x0+gridSize,y0+pointer);
        }

        g.fillOval(10, 10, 40, 50);
        for(int i = 0; i<29;i++)
            for(int j = 0; j<29;j++)
                if(grid[i][j] != markerColor.none)
                    placeMarker(i,j,grid[i][j]);
    }
    public void placeMarker(int X, int Y, markerColor m) {
        int x = X*step+2*step/10, y = Y*step+2*step/10;
        switch(m) {
        case red:
            graph.setColor(Color.red);
            break;
        case green:
            graph.setColor(Color.green);
            break;
        default :
            graph.setColor(Color.blue);
        }
        graph.fillOval(x0+x,y0+y, step*6/10, step*6/10);

    }


    public static void main(String arg[]){
        JFrame frame = new JFrame();
        frame.add(new SSCCE(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}