import java.awt.event.*;
Timer t = new Timer(10, //will run every 10 ms
                    new Listener());
t.start();

private class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        //Code here will execute every (10) ms.
    }
}