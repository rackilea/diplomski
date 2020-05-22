.................................
        menu.add(item2);
        setBounds(100, 100, 100, 100);
        setVisible(true);
        submenu.add(subitem1);
        submenu.add(subitem2);
        SwingUtilities.updateComponentTreeUI(mb); //This line updates menu representation
    }
................................