final Timer timer = new Timer(1, null);
    timer.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt)
        {

            double width = myFrame.getBounds().getWidth();

            if(isExpanded == false)
                width += FRAME_PIXEL_CHANGE;
            else
                width -= FRAME_PIXEL_CHANGE;



            if(myFrame.getBounds().getWidth() >= FRAME_SIZE_EXPANDED && isExpanded == false)
            {
                myFrame.setBounds(FRAME_X, FRAME_Y,  FRAME_SIZE_EXPANDED, FRAME_HEIGTH);
                btnExpand.setIcon(new ImageIcon(GUI.class.getResource("/img/close.png")));
                timer.stop();
                isExpanded = true;
            }
            else if(myFrame.getBounds().getWidth() <= FRAME_SIZE_REGULAR && isExpanded == true)
            {
                myFrame.setBounds(FRAME_X, FRAME_Y,  FRAME_SIZE_REGULAR, FRAME_HEIGTH);
                btnExpand.setIcon(new ImageIcon(GUIMain.class.getResource("/img/expand.png")));
                timer.stop();
                isExpanded = false;
            }
            else
            {
                myFrame.setBounds(FRAME_X, FRAME_Y, (int) width, (int) FRAME_HEIGTH);
                btnExpand.setBounds((int) (width-36), 246, 36, 36);
            }
        }
    });

    return timer;