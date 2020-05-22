container.setLayout(new BorderLayout());

JPanel panelForMatrices = new JPanel(new GridLayout(0,1));
panelForMatrices.add(matricepc);
panelForMatrices.add(matrice);
container.add(panelForMatrices, BorderLayout.CENTER);

JPanel lateralPanel = ...
container.add(lateralPanel, BorderLayout.EAST);