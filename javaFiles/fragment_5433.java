for (final HashMap h : menuLijst) {
    final String vraag = (String) h.get("vraag");
    final JMenuItem qMenu = new JMenuItem(vraag);
    informatie.add(qMenu);
    qMenu.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
               // here event.getSource() is the same as qMenu
               System.out.println("Menu "+qMenu+" with label "+vraag+" has been pressed");
               System.out.println("HashMap is "+h);
         }
    });
}