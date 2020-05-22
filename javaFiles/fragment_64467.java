JPanel boxContainer = new JPanel();
boxContainer.setLayout(new BoxLayout(boxContainer, BoxLayout.Y_AXIS));

JPanel boxContainerOuter = new JPanel();
boxContainerOuter.setLayout(new BorderLayout());
boxContainerOuter.add(boxContainer, BorderLayout.NORTH);

JScrollPane mainScrollPane = new JScrollPane(boxContainerOuter);