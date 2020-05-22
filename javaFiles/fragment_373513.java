private void frame1(){

JFrame Introframe = new JFrame();
IntroText introtext = new IntroText(); // your panel
Introframe.add(introtext); // add panel

Introframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Introframe.setLocation(600,100);
Introframe.pack();
Introframe.setVisible(true);

Introframe.remove(introtext); // remove it now

}