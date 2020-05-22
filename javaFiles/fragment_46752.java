SwingUtilities.invokeLater(new Runnable(){
    @Override
    public void run(){
        comboBox_2.addItem(new(dane.getString("year")));
    }
});