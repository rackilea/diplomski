JButton submitter = new JButton("Submit Request");
submitter.setBounds(145, 204, 144, 23);
contentPane.add(submitter);
submitter.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        Connection connection = null;
        Statement insertStmt = null;

        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/maintenance","root","password");
            insertStmt = connection.createStatement();
            insertStmt.executeUpdate("INSERT INTO submit (submit_request,loc_string) VALUES ('" + request.getText() + "','" + schools.getText() + "')");
        }
    }
});

try
    {
        insertStmt.close();
        connection.close();
    } 
catch (Exception e)
    {
        e.printStackTrace();
    }


public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Submit frame = new Submit();
                frame.setVisible(true);
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
    }
};