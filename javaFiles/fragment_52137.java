con.begin("a2");
    while (true) {
        StompFrame message = null;
        try {
            message = connection.receive(5000);
        } catch (Exception e) {
            break;
        }
        System.out.println(mes.getBody());
        con.ack(message, "a2");
    }
    connection.commit("a2");