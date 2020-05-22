public class Frame1 extends javax.swing.JFrame implements Observable{

    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton submitButton;


    private List<Observer> observers = new ArrayList<>();

    public Frame1() {
        initComponents(); // 2 text fields and 1 button
    }

    private void initComponents() {
        // I will skip this part you can generate it with NetBeans
        // Basically initialise jTextField1, jTextField2, and submitButton
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt)    {                                             
        String[] row = {jTextField1.getText(), jTextField2.getText()};        
        notifyObserver(row);
    }  


    @Override
    public void addObserver(Observer o) {
        observers.add(o);  // subscribe new observer
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o); // unsubscribe new observer
    }

    @Override
    public void notifyObserver(String[] row) {
        for (Observer observer: observers) { 
            observer.update(row);  // notify all observers that new row values are available
        }
    } 
}