public void loadQuestions() {
        try {

            String sql = "select * from "
                    + hommer.getSelectedItem()
                    + " where id= ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, getCount());
            rs = pst.executeQuery();
            if (rs.next()) {
                question_space.setText(rs.getString("questions"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }