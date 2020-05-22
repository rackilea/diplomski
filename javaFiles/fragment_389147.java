//Again, this is where I'm having issues..
DefaultPanel dp = (DefaultPanel)baseFrame.getContentPane();
jdp.setVisible(true);
baseFrame.setContentPane(jdp);
DefaultInternalFrame dif = new DefaultInternalFrame();
jdp.add(dif);
dif.setContentPane(dp);
dif.setVisible(true);
dif.moveToFront();

DefaultInternalFrame dif2 = new DefaultInternalFrame();
jdp.add(dif2);
dif2.setContentPane(new DefaultPanel());
dif2.setVisible(true);
dif2.moveToFront();

baseFrame.validate(); // <-- Call me