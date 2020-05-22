public void email() throws Exception {

    String sql = "SELECT id,subject,recipient,content FROM emailqueue WHERE status='Pending' ";

    while (true) {

        try (PreparedStatement statement = con1.prepareStatement(sql); ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                String subject = rs.getString("subject");

                String recipient = rs.getString("recipient");

                String content = rs.getString("content");

                String id = rs.getString("id");

                sendEmail(recipient, subject, content, id);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    con1.close();
    Thread.sleep(2000);

}