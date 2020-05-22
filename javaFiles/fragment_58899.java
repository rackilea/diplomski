String q2 ="select date('now')";

                        PreparedStatement pst5 = con.prepareStatement(q2);
                        ResultSet rs55 = pst5.executeQuery();
                        //JOptionPane.showMessageDialog(null,rs55.getString(1));    

                        if(rs55.getString(1).compareTo(rst.getString("Due_Date"))>0){