HITProperties props = new HITProperties("mturk.properties");
String question = FileUtil.readAsString(new File("question.html"));
HITQuestion hitQuestion = new HITQuestion();
hitQuestion.setQuestion(question);
HIT awsHit = service.createHIT(null, props.getTitle(),
            props.getDescription(), props.getKeywords(),
            question, props.getRewardAmount(),
            props.getAssignmentDuration(), props.getAutoApprovalDelay(),
            props.getLifetime(), props.getMaxAssignments(),
            props.getAnnotation(), props.getQualificationRequirements(),
            null
);