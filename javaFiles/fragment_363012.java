publisher.connectWith()
        .simpleAuth()
            .username("Username")
            .password("Password".getBytes())
            .applySimpleAuth()
        .send();