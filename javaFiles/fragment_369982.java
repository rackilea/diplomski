public class AnimationOfFunction(){
    public static void main(String[] args){
        new AnimationOfFunktion().createAndShowGui(); //as from java tutorials
    }

    private BufferedImage img;
    private Graphics gr;
    private void createAndShowGui(){
        calculateData(); first of all we create the data!
        JFrame frame = new JFrame();//then create your frame here
        JPanel panel = createContent(); //create your drawing panel here
        frame.add(panel);//adding drawing panel
        frame.pack(); //setting the proper size of frame
        frame.setVisible(true); //show frame          
        startAnimation(panel); //this is important - after showing the frame you start your animation here!
    }
}