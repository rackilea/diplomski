class Toolbar extends JPanel {

   private JButton startBtn;
   private JButton stopBtn;
   private TextPanel textPanel;

   public Toolbar() {
      startBtn = new JButton("Start");
      stopBtn = new JButton("Stop");
      // textPanel = new TextPanel();  // *** note change

      setLayout(new FlowLayout(FlowLayout.LEFT));
      add(startBtn);
      add(stopBtn);

      startBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
            if (textPanel != null) {
               System.out.println(textPanel.getTextAreaText());
            }
         }
      });
   }

   //   **** note this method ****  
   public void setTextPanel(TextPanel textPanel) {
      this.textPanel = textPanel;
   }
}