public static Result index() {
        init();
        CreateTopicRuleRequest another_test = new CreateTopicRuleRequest();
        another_test.setRuleName("test");
        TopicRulePayload topicRulePayload = new TopicRulePayload();
        topicRulePayload.setDescription("A test rule");
        topicRulePayload.setSql("SELECT state.reported.turbineStatus FROM '$aws/things/turbine1/shadow/update/accepted' WHERE state.reported.turbineStatus=true");
        ArrayList<Action> actionList = new ArrayList();
        Action action = new Action();
        S3Action s3 = new S3Action();
        s3.setRoleArn("arn:aws:iam::442759113924:role/sushant");
        s3.setBucketName("bajra-iot-test");
        s3.setKey("bajra-iot-test");

        action.setS3(s3);
        actionList.add(action);
        topicRulePayload.setActions(actionList);
        another_test.setTopicRulePayload(topicRulePayload);
        CreateTopicRuleResult test = awsIotClient.createTopicRule(another_test);

        return ok(index.render("iot"));
    }