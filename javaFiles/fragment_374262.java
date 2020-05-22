List<Map<String, Object>> questions = new ArrayList<>();
questions.add(new HashMap<String, Object>(){{
    put("QID", 1);
    put("Question", "text");
}});
questions.add(new HashMap<String, Object>(){{
    put("QID", 2);
    put("Question", "text");
}});


Document document  = new Document("_id", 1001)
        .append("topic", "topic")
        .append("empid", 5)
        .append("teacher", "teacher")
        .append("date", 555)
        .append("questions", questions);

collection.insertOne(document);