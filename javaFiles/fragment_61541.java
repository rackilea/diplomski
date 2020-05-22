if(Items.flaskpickup == true)
    {
        JButton btnHydrogen = new JButton("Hydrogen");
        btnHydrogen.setIcon(new ImageIcon(ChemistryTeachersDesk.class.getResource("/Images/flask_small.png")));
        btnHydrogen.setVisible(true);
        toolBar.add(btnHydrogen);
        return btnHydrogen;
    }