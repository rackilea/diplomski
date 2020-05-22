class update implements ActionListener {
    JTextArea output;
    int stationNo;
    Graphic graphic;

    update(JTextArea out, int station, Graphic p) {
        output = out;
        stationNo = station;
        graphic = p;
    }

    public void actionPerformed(ActionEvent e)   {
        output.append("Start Train");
        stationNo = stationNo + 1;
        graphic.newStation(stationNo);
        graphic.repaint();
        output.append(" " + stationNo);
    }
}