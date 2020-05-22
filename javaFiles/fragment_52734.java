frame1.addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
       //check is frame 2 is open.. if it is then return without doing anything, else
       // frame1.dispose();
    }
});