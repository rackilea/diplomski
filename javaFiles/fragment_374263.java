Document foundDocument = collection.find(new Document("_id", 1001)).first();
    List<Map> foundQuestions = (List) foundDocument.get("questions");
    for (Map foundQuestion: foundQuestions) {
        Integer qid = (Integer) foundQuestion.get("QID");
        String questionValue = foundQuestion.get("Question").toString();
        System.out.println(qid + " : " + questionValue);
    }