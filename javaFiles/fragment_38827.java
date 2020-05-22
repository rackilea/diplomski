for (int mi=0; mi<colors.length; mi++){

    String pos = Character.toUpperCase(colors[mi].charAt(0)) + colors[mi].substring(1);
    JMenuItem Jmi =new JMenuItem(pos);
    Jmi.setIcon(new IconA(colors[mi]));

    // workaround:
    final Integer innerMi = new Integer(mi);

    Jmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem item = (JMenuItem) e.getSource();
                IconA icon = (IconA) item.getIcon();
                // HERE YOU USE THE FINAL innerMi variable and no errors!!!
                Color kolorIkony = getColour(colors[innerMi]); 
                textArea.setForeground(kolorIkony);
            }
        });

        mnForeground.add(Jmi);
    }
}