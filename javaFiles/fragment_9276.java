ArrayList email= new ArrayList();
      while(rs.next()) {

                email.add(rs.getString("column_name"));
      }


    Message message = new MimeMessage(session);

   InternetAddress[] address = new InternetAddress[email.size()];
    for (int i = 0; i < email.size(); i++) {
        address[i] = new InternetAddress(email.get(i));
    }
     message.setRecipients(Message.RecipientType.TO, address);