AddBookDialog dialog = new AddBookDialog(this);
dialog.setModal(true);

dialog.getSaveBtn().addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

      Object[] added = new Object[]{dialog.getBookID(), dialog.getBookName(), dialog.getIsbn(), dialog.getBorrowStatus(), dialog.getDate()};
      model.addRow(added);

            }
        });

// importent set visible after ActionListener!! 
dialog.setVisible(true);