//executed once
ConnectionFactory factory = new ConnectionFactory();

factory.setHost("someHost");
factory.setUsername("user");
factory.setPassword("pass");

Connection connection = factory.newConnection();