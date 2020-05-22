Email[] mail = new Email[length];

    int i=0;

    while(rs.next())
    {
    mail[i] = new Email(); // or use appropriate constructor parameters
    mail[i].setMessage((String) rs.getString(5));
    mail[i].setTitle((String) rs.getString(4)); 
    mail[i].setSender((String) rs.getString(2));
    mail[i].setReceiver((String) rs.getString(1));
    i++;
    }