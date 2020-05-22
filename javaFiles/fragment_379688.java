public class Input extends javax.swing.JFrame {
  Latihan latihan = new Latihan();

  public Input() {
     initComponents();
   }                      

  private void btnKirimActionPerformed(java.awt.event.ActionEvent evt) {                                         
      ...
      try {
        ...
        Tabel t = new Tabel(latihan);
        ...
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
      }
  }                                        

}

public class Tabel extends javax.swing.JFrame {

  public Tabel(Latihan latihan) {
    ...
    addDataToTable(latihan);
  }    

  public void addDataToTable(Latihan latihan){
    ...
    ArrayList<String[]> arr = latihan.getLaporan();
    ...
  }                
}