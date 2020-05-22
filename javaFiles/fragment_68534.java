public class Launcher{
    public static void main(String[] args){
        final FrameCreator f = new FrameCreator();
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                f.createAndShowFrame();
            }
        });
    }
}