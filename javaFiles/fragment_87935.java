final Object obj = new Object() ; // or something to receive your dialog's answer(s)
Runnable r = new Runnable() {

   void run() {
     Dialog d = new Dialog() ;

     Button b = new JButton("ok") ;
     b.addActionListener(new ActionListener() {
         void actionPerformed(ActionEvent e) {
             synchronize(obj) { // can lock when worker thread releases with wait
                obj.notify() ; // signals wait
             }
         }
     }) ;

   }
} ;

synchronize( obj ) {
   SwingUtilites.invokeLater(r) ; // executs r's run method on the swing thread
   obj.wait() ; // releases obj until worker thread notifies
}