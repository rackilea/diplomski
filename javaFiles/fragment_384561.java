// p is your paragraph object
XWPFRun r = p.createRun();
r.setColor("ff0000");
r.setText("This text is red");
r = p.createRun();
r.setText(" but this text is black");