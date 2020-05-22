public class Solu implements ActionListener {
        File filename;
        JFrame wind = new JFrame("V");
        JButton btnOpen = new JButton("open");
        JPanel pnlSound=new JPanel();
public Solu() {
    wind.setSize(400, 500);
    wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    wind.add(btnOpen);
    btnOpen.setBounds(6, 71, 75, 23);
    pnlSound.add(btnOpen);
    wind.add(pnlSound);
    btnOpen.addActionListener(this);
    wind.setVisible(true);  }
  public static void main(String[] args){
    new  Solu();}
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource()==btnOpen){
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new              File("C://Users//V//Desktop"));

         int result = filechooser.showOpenDialog(new JFrame());
          if (result == JFileChooser.APPROVE_OPTION) {
           File selectedFile = filechooser.getSelectedFile();
           System.out.println("Selected file: " +selectedFile.getAbsolutePath());
          }}}}