public class BoxListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        String s= price.getText();
        if(s.matches("[0-9]+"))               //Perform validation before parsing string
            inputPrice = Integer.parseInt(s);
    }
}