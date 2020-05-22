ArrayList<JLabel> listadelabels = new ArrayList<JLabel>();
ArrayList<JTextField> listadetextfields = new ArrayList<JTextField>();
ArrayList<JCheckBox> listadecheckbox = new ArrayList<JCheckBox>();
...
Statement stmt=db.createStatement();
    ResultSet sst_ResultSet = stmt.executeQuery(query);
    JPanel p_obtenerregistro = new JPanel(new GridLayout(0,3));
    while (sst_ResultSet.next()) {
        listadelabels.add(new JLabel(sst_ResultSet.getString(1)));
        listadetextfields.add(new JTextField(12));
        listadecheckbox.add(new JCheckBox());
    }
    for(int i=0 ; i<listadelabels.size(); i++){
        listadecheckbox.get(i).addItemListener(this);
        p_obtenerregistro.add(listadecheckbox.get(i));
        p_obtenerregistro.add(listadelabels.get(i));
        listadetextfields.get(i).setEditable(false);
        p_obtenerregistro.add(listadetextfields.get(i));
    }