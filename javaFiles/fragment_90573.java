try {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver nextElement = drivers.nextElement();
            JOptionPane.showMessageDialog(null, nextElement.acceptsURL("jdbc:postgresql://localhost:5432/postgres"));
            JOptionPane.showMessageDialog(null, nextElement.acceptsURL("Jdbc:postgresql://localhost:5432/postgres"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }