public void mouseClicked(MouseEvent evt) { 
    if (evt.getButton()==MouseEvent.BUTTON1){
        leftClick = true; clickCount = 0;
        if(evt.getClickCount() == 2) doubleClick=true;
        Integer timerinterval = (Integer)Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");

                   timer = new Timer(timerinterval, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {  
                        if(doubleClick){
                            System.out.println("double click.");
                            sb = new StringBuffer();
                            sb.append("Double Click");
                            clickCount++;
                            if(clickCount == 2){
                                rfbProto.capture();
                                clickCount=0;
                                doubleClick = false;
                            }

                        } else {

                            sb = new StringBuffer();
                            sb.append("Left Mouse");
                            System.out.println("single click.");
                            rfbProto.capture();
                        }
                    }               
                });
                timer.setRepeats(false);
                timer.start();
                if(evt.getID()==MouseEvent.MOUSE_RELEASED) timer.stop();
    }           
    }