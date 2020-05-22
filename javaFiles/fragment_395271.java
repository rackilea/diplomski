try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        String msg = "The com.mysql.jdbc.Driver is missing\n"
                + "install and rerun the application";
        JOptionPane.showMessageDialog(this, msg, this.getTitle(), JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }