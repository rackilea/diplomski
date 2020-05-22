JSONObject object=new JSONObject();

    JSONObject holder=new JSONObject();
    JSONArray taskAssings = new JSONArray();

    JSONObject taskAssigned=new JSONObject();
    taskAssigned.put("id", "3c814009-82f7-4246-bc51-2d263e758561");

    JSONObject taskAssignee=new JSONObject();
    taskAssignee.put("id", "3c814009-82f7-4246-bc51-2d263e758561");

    holder.put("taskAssigned",taskAssigned);
    holder.put("taskAssignee",taskAssignee);
    taskAssings.add(holder);

    object.put("taskAssings", taskAssings);

    JSONObject status=new JSONObject();
    status.put("id", "7d8a0d80-5c93-46cc-982d-47399503beaa");
    object.put("status", status);

    JSONObject assignTo=new JSONObject();
    assignTo.put("id", "3c814009-82f7-4246-bc51-2d263e758561");
    object.put("assignTo", assignTo);


    JSONObject priority=new JSONObject();
    priority.put("id", "842a9a9c-4a1a-4f70-bf4d-8181b482f651");
    object.put("priority",priority);

    object.put("description", "TestTaskDescription");
    object.put("name", "taskname");