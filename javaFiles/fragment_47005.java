public void golpe(final int pbola, int pvelocidad, String pdireccion, final JLabel[] listalabels) throws InterruptedException{

    listabolas[pbola].setVelocidad(pvelocidad);
    listabolas[pbola].setDireccion(pdireccion);

    Timer timer = new Timer(40, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

            if (listabolas[pbola].getVelocidad() == 0) {
                ((Timer)evt.getSource()).stop();
            } else {            
                moverBola(pbola, listalabels);
            }

        }
    });
    timer.setRepeats(true);
    timer.start();

}