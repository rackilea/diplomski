public class MainTester {
public static void main(String[] args){
    JFrame frame=new JFrame("Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    frame.setResizable(false);
    MandelbrotGenerator genImg = new MandelbrotGenerator();
    int[][] list = new int[400][400];
    int iterations=0;
    for(int x=0; x<400;x++){
        for(int y=0; y<400;y++){
            iterations = genImg.calculateMandelbrot((double)x, (double)y, 400, 400);
            list[x][y]=iterations;
            //System.out.println(list[x][y]);
        }
    }
    VisualComponent comp = new VisualComponent(400,400, list);
    frame.add(comp);
    frame.setVisible(true);
}
}