[{"Text":"Here is some text","Make":"Admin","Name":"Hello"},
{"Text":"Here is some text","Make":"John","Name":"Hello"},
{"Text":"Here is some text","Make":"Admin","Name":"Hello"}]

obj = parser.parse(new FileReader("Project.json"));
JSONArray jsonArray = (JSONArray) obj;

for (JSONObject jsonObject : jsonArray)
{
    String name = (String) jsonObject.get("Text");
    System.out.println(name);
}