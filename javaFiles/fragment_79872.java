public class DataMouseHandler extends MouseAdapter {
    public void mouseClicked(MouseEvent evt) {

        final Data data = NewPerson.createPerson(frame);
        if (data != null) {

            String Val = data.CBvalue;

            if ("mother".equals(Val)) {

                JLabel lblHomer = createPersonalLabel(data, this);

                cooX = cooX + 20;
                cooY = cooY - 20;
                panel_1.add(lblHomer, "cell " + cooX + " " + cooY);
                panel_1.revalidate(); 
            }
        }
    }
}