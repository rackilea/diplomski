centerPanel_scroll = new JScrollPane();
// centerPanel_scroll.setBounds(261, 71, 750, 698);
center_panel.setPreferredSize(new Dimension(750, 698));
center_panel = new JPanel();
// center_panel.setLayout(null);
center_panel.setPreferredSize(new Dimension(900, 800));
center_panel.setBackground(Color.cyan);
centerPanel_scroll.setViewportView(center_panel);
main_panel.add(centerPanel_scroll);