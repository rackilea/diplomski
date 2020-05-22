class MyPanel extends JPanel {

    private Timer t1,t2,startingTimer;

    MyPanel() {
       t1=new Timer(60,new AbstractAction() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               if(!MyPanel.this.isVisible()) {//if the panel is not visible
                   ((Timer)(ae.getSource())).stop();
               }
           }
       });
       startingTimer=new Timer(100,new AbstractAction() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               if(MyPanel.this.isVisible()) {//if the panel is visible
                   t1.start();//start the timers
                   t2.start();
                   ((Timer)(ae.getSource())).stop();//dont forget we must stop this timer now

               }
           }
       });
       startingTimer.start();//start the timer which will check when panel becomes visible and start the others as necessary
    }

}