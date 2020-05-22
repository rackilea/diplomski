class FilePanel extends JPanel {

   private File file;
   private JTextArea textArea;
   private String name;

   public FilePanel(File file) throws FileNotFoundException, IOException {
      this.file = file;
      setLayout(new BorderLayout());

      textArea = new JTextArea();
      JScrollPane scroll = new JScrollPane(textArea);
      add(scroll, BorderLayout.CENTER);

      textArea.read(new FileReader(file.getAbsolutePath()), null);
      name = file.getName();
   }

   public File getFile() {
      return file;
   }

   public JTextArea getTextArea() {
      return textArea;
   }

   public String getName() {
      return name;
   }

}