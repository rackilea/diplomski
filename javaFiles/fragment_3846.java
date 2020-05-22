class whatEver implements ActionListener{
    JButton btnNext = new JButton();
    static int fileNumber = 0;
    static int totalFiles;

   void functionLoadInterface ()  //Function with
    {
        btnNext.addActionListener(this); 
        //Initialize array ImageArray with file paths.
    }

   public void cycleImage()
    { 
         String file = ImageArray[fileNumber%totalFiles];
         //Code to load the image wherever follows
    } 

   public void actionPerformed(ActionEvent e) 
    {
         filenumber++;
         this.cycleImage();
    }