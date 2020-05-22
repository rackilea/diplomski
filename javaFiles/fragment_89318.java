if (rs.next()) {
        if ("B".equals(rs.getString("Role"))) {
            JOptionPane.showMessageDialog(null, "Username and password are correct");
            AdminJFrame s = new AdminJFrame();
            this.dispose();
            s.setVisible(true);
        } else
            JOptionPane.showMessageDialog(null, "You don't have the required role");
    } else 
        JOptionPane.showMessageDialog(null, "Username and password did not match");