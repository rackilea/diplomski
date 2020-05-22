String[] arr = { "c02bc683-fcd7-47a5-b157-853e26ed099e", "f8e1c9d7-ae45-4433-a315-726c1d912d09" };
    JSONArray jsonArray = new JSONArray(arr);

    JSONObject json = new JSONObject();
    json.put("listId", jsonArray);

    System.out.println(json); // {"listId":["c02bc683-fcd7-47a5-b157-853e26ed099e","f8e1c9d7-ae45-4433-a315-726c1d912d09"]}