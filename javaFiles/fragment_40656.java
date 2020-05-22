public class lines extends JPanel {

static int deltaX;
static int deltaY;
static int DY2;
static int DX2;
static int Di;

public static void main (String[] args) {
JFrame f = new JFrame("Line vs Line");
f.pack();
f.setVisible(true);
f.setSize(300,300);
f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
lines h = new lines();
f.getContentPane().add(h);

}

public static void basic(int x1, int y1, int x2, int y2, Graphics g){
int deltaX = x2-x1;
int deltaY = y2-y1;
float m = (float)deltaY/(float)deltaX;
float c = y1 - (m*x1);
for (int x=x1; x<x2; x++){
float floatY = (m*x) + c;
int y = Math.round(floatY);
g.drawLine(x,y,x,y);
}
}

public static void brz(int x1, int y1, int x2, int y2, Graphics g){
deltaX = x2-x1;
deltaY = y2-y1;
DY2 = 2* deltaY;
DX2 = 2* deltaX;
Di = DY2 - deltaX;
int x = x1;
int y = y1;  
int prevy;
while (x<x2) {
x++;
prevy = y;
if (Di > 0){
y++;
}
g.drawLine(x,y,x,y);
Di = Di + DY2 - (DX2 * (y - prevy));
}
}

public static void drawthoselines(Graphics g){

}
@Override
protected void paintComponent(Graphics g) {
basic(10,10,40,30,g);
basic(10,10,40,90,g);
brz(50,50,150,60,g);
brz(50,50,150,120,g);
brz(50,50,150,140,g);
}

}