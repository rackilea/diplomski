Object obj = parser.parse(new FileReader("E:\\json.txt"));

    JSONObject jsonObject = (JSONObject) obj;

    out.println(jsonObject.get("from_excel"));

    JSONArray solutions = (JSONArray) jsonObject.get("from_excel");

    Iterator iterator = solutions.iterator();
    while (iterator.hasNext()) {
        out.println(iterator.next());
    }