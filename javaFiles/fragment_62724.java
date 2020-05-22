final Session session = Diffusion.sessions().principal("admin").password("password").open("ws://localhost:8080");

final TopicControl topicControl = session.feature(TopicControl.class);

final TopicSpecification specification =
            topicControl.newSpecification(TopicType.JSON)
                .withProperty(TopicSpecification.REMOVAL, "when subscriptions < 1 for 10s");