JsonObject issuetype = new JsonObject();
        issuetype.addProperty("id", "10004");
        JsonObject project = new JsonObject();
        project.addProperty("key", "TES");
        JsonObject reporter = new JsonObject();
        reporter.addProperty("name", "TestUser");
        JsonObject summary = new JsonObject();
        summary.addProperty("summary", "Screen not responding");
        JsonObject description = new JsonObject();
        description.addProperty("description", "New Bug in UI. Screen not responding");
        JsonObject assignee = new JsonObject();
        assignee.addProperty("name", "Test");

        JsonObject field = new JsonObject();
        field.add("issuetype", issuetype);
        field.add("project", project);
        field.add("reporter", reporter);
     // field.add("summary", summary);
        field.addProperty("summary", "Screen not responding");
        field.add("description", description);
        field.add("assignee", assignee);

        JsonObject fields = new JsonObject();
        fields.add("fields", field);

        System.out.println(fields.toString());