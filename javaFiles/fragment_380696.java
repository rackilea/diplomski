class LoadButton implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("save.ser"));
            Object booksIn = oi.readObject();
            bookList = (LinkedList<Book>)booksIn;
            sortAndDisplay();
            oi.close();
        } catch (Exception exc){}
    }
 }