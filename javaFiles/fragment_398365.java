JSONArray array = new JSONArray();

    JSONObject container = new JSONObject();

    JSONObject showMarks = new JSONObject();
    showMarks.put("show", true);

    JSONArray markData = new JSONArray();

    JSONObject firstMark = new JSONObject();
    firstMark.put("label", "First Mark");
    firstMark.put("position", 3);
    firstMark.put("labelVAlign", "top");

    JSONObject secondMark = new JSONObject();
    secondMark.put("label", "Second mark");
    secondMark.put("position", 9);
    secondMark.put("labelVAlign", "top");

    markData.add(firstMark);
    markData.add(secondMark);

    container.put("marks", showMarks);
    container.put("data", new JSONArray());
    container.put("markData", markData);

    array.add(container);
    log.info(array.toString(4));