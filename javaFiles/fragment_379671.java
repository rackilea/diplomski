Bedrijf bedrijf;
List<Netwerk> panelen = new ArrayList<>();

//...

    private void refreshScreen() {
    //reset list with panels
    panelen.clear();

    //init counter
    int i = 0;

    List<Subnet> subnets = bedrijf.getSubnets();

    //empty the interface
    jPanel1.removeAll();

    //create a 'Netwerk' jPanel for each subnet
    for (Subnet element : subnets) {
        Netwerk n = new Netwerk(element.getNaam(), element.getNetwerkAdres(), element.getSubnetMask(), element.getHosts());
        final int finalI = i;
        i++;

        //<editor-fold defaultstate="collapsed" desc="ActionListenersKnoppen">
        n.jButton_Naam.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_In_Panel_ActionPerformed(evt, finalI, "jButton_Naam");
            }
        });

        //... some more ActionListeners here ...

        n.jButton_VerwijderSubnet.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_In_Panel_ActionPerformed(evt, finalI, "jButton_VerwijderSubnet");
            }
        });
        //</editor-fold>

        jPanel1.add(n);
        panelen.add(n);//thanks to Oscar Ryz @ http://stackoverflow.com/questions/370310/java-get-jpanel-components
    }
    repaint();
}