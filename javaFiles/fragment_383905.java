final JScrollPane jScrollPane = new JScrollPane(list,
     JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

final JPanel panel = new JPanel(new BorderLayout(BORDER_SIZE, BORDER_SIZE));
panel.setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, 
      BORDER_SIZE, BORDER_SIZE));

panel.add(jScrollPane);