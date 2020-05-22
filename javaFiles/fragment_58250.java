public class PersonalInfo extends JPanel {
    private void initialize() {
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                GenerateRDF generator = new GenerateRDF();
                generator.setRDF();
            }
        }); 
   }
}