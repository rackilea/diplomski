GsonBuilder builder = new GsonBuilder();
builder.registerTypeAdapter(Book.class, new BookTypeAdapter());

Gson gson = builder.create();

Book book = gson.fromJson("{" +
        " \"user1\": {" +
        "   \"timeSpent\": \"20.533333333333335h\"," +
        "   \"worklog\": [" +
        "     {" +
        "       \"date\": \"06/26/2013\"," +
        "       \"issues\": [" +
        "         {" +
        "           \"issueCode\": \"COC-2\"," +
        "           \"comment\": \"\ncccccc\"," +
        "           \"timeSpent\": \"20.533333333333335h\"" +
        "         }" +
        "       ]," +
        "       \"dayTotal\": \"20.533333333333335h\"" +
        "     }" +
        "   ]" +
        " }," +
        " \"admin\": {" +
        "   \"timeSpent\": \"601.1h\"," +
        "   \"worklog\": [" +
        "     {" +
        "       \"date\": \"06/25/2013\"," +
        "       \"issues\": [" +
        "         {" +
        "           \"issueCode\": \"COC-1\"," +
        "           \"comment\": \"\"," +
        "           \"timeSpent\": \"113.1h\"" +
        "         }" +
        "       ]," +
        "       \"dayTotal\": \"113.1h\"" +
        "     }," +
        "     {" +
        "       \"date\": \"06/26/2013\"," +
        "       \"issues\": [" +
        "         {" +
        "           \"issueCode\": \"COC-1\"," +
        "           \"comment\": \"\"," +
        "           \"timeSpent\": \"8h\"" +
        "         }," +
        "         {" +
        "           \"issueCode\": \"COC-2\"," +
        "           \"comment\": \"\"," +
        "           \"timeSpent\": \"480h\"" +
        "         }" +
        "       ]," +
        "       \"dayTotal\": \"488h\"" +
        "     }" +
        "   ]" +
        " }" +
        "}", Book.class);

String json = gson.toJson(book);