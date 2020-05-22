MyPanel panel=new MyPanel();

...

panel.destory();//stop music, timers etc

frame.remove(panel);

//refresh frame to show changes
frame.revalidate(); 
frame.repaint();