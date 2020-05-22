public static void main(String args[]){
    File file=.....;
    final GraphMain applet=new GraphMain(file);
    applet.init();
    JFrame f=new JFrame("Title goes here");
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    f.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            applet.stop();
            applet.destroy();
            System.exit(0);
        }
    });
    f.setLayout(new BorderLayout());
    f.add(applet, BorderLayoyt.CENTER);
    f.setSize(whatever size your applet is);
    applet.start();
    f.setVisible(true);
}