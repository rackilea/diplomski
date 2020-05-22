I dont understand your need. "A click A go jframe A" doesnot make sense.
if you want to go to another jFrame when clicking a label
Try this

    private void yourlabelMouseClicked(java.awt.event.MouseEvent evt) {
          //  either you can hide the current jFrame by setting 
            jFrame.setVisible(false);
            newjFrame.setVisible(True);
                    or
            make these jFrames in 2 different classes that make simple invocations
        }