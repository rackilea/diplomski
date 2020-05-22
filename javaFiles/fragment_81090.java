private JPanel criarPainelCliques() {

       JLabel lbl = new JLabel("Número de Cliques: ");
       JPanel p = new JPanel();
       lbl.setFont(lbl.getFont().deriveFont(20.0f));
       p.add(lbl, BorderLayout.CENTER);
       p.add(l1);

       return p;
    }