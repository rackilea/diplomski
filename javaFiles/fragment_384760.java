try {
           PreparedStatement pps;
          pps = cn.prepareStatement("INSERT INTO ventas (nombre,precio,cant)VALUES (?,?,?)");
                pps.setString(1, productotxt.getText());
                pps.setInt(2, Integer.parseInt(preciotxt.getText()));
                pps.setInt(2, Integer.parseInt(cantidadtxt.getText()));        
                pps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso!");
            } catch (SQLException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }