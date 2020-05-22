List<JPanel> panels = new ArrayList<JPanel>();
for (int i = 0; i < 4; i++) {
    JPanel p = new JPanel();
    p.setName("1337 PANEL No.: " +String.valueOf(i));
    panels.add(p);
}
for (JPanel p : panels) {
    System.out.println(p.getName());
}