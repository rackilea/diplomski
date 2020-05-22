insertButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String bookName = firstInsert.getText();
            String authorName = secondInsert.getText();
            String price = thirdInsert.getText();
            Book book = new Book(bookName,authorName, price):
            try {
                BookQuerie.insertBooks(book);
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        });