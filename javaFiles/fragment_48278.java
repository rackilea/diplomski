private void btRunConfiguration(ActionEvent evt) {
getContentPane().removeAll();
getContentPane().add( topPanel );
getContentPane().repaint();

setTitle("Simple Table Application");
setSize(300, 100);
setBackground(Color.gray);
pack();
setVisible(true);
  new MyWorker().execute();

}
class MyWorker extends SwingWorker<Void, Void> {



@Override
public Void doInBackground() {

     updateTable();
return null;
}

@Override
protected void done() {

} }