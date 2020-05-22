imp.addActionListener(new ActionListener() {

  public void actionPerformed(ActionEvent event) {
    JFileChooser fileopen = new JFileChooser();

    int ret = fileopen.showDialog(null, "Open file");

    if (ret == JFileChooser.APPROVE_OPTION) {
      try {
        BufferedReader fileStream = new BufferedReader(new FileReader("src/contacts.buab"));
        while (true) {
          String fileInput = fileStream.readLine();
          if (fileInput == null)
            break;

          Contact a = new Contact();
          a.setname(fileInput);
          a.setsurname(fileStream.readline());
          a.setphone(fileStream.readLine());
          a.setmobile(fileStream.readLine());
          a.setaddress(fileStream.readLine());
          a.setpostcode(fileStream.readline());
          Contacts.add(a);
          System.out.println(a.getname());

        }

        fileStream.close();
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ioe.getMessage());
      }
      displaycontact();
    }
  }
});