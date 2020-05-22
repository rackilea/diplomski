ConnectionFactory factory = new ConnectionFactory();
        Connection connection = null ;
        try {
            connection = factory.newConnection(mqHost, mqPort);
        } catch (IOException ioe) {
            log.error("Unable to create new MQ connection from factory.", ioe) ;
        }

        Channel channel = null ;
        try {
            channel = connection.createChannel();
        } catch (IOException ioe) {
            log.error("Unable to create new channel for MQ connection.", ioe) ;
        }

        try {
            channel.queueDeclare("celery", false, false, false, true, null);
        } catch (IOException ioe) {
            log.error("Unable to declare queue for MQ channel.", ioe) ;
        }

        try {
            channel.exchangeDeclare("myqueue", "direct") ;
        } catch (IOException ioe) {
            log.error("Unable to declare exchange for MQ channel.", ioe) ;
        }

        try {
            channel.queueBind("celery", "myqueue", "myqueue") ;
        } catch (IOException ioe) {
            log.error("Unable to bind queue for channel.", ioe) ;
        }

            // Generate the message body as a string here.

        try {
            channel.basicPublish(mqExchange, mqRouteKey, 
                new AMQP.BasicProperties("application/json", "ASCII", null, null, null, null, null, null, null, null, null, "guest", null, null),
                messageBody.getBytes("ASCII"));
        } catch (IOException ioe) {
            log.error("IOException encountered while trying to publish task via MQ.", ioe) ;
        }