JSONArray questionsArray = new JSONArray();

JSONArray one = new JSONArray();
one.put("ELSYS")
one.put("ELSYS2")
one.put("ELSYS3")
one.put("ELSYS4")
JSONObject firstObject = new JSONObject()
firstObject.put("question", "6*2")//(key, value)
firstObject.put("answers", one) 
questionsArray.put(firstObject ) 

JSONArray two = new JSONArray();
two.put("1024")
two.put("2048")
two.put("512")
two.put("64")
JSONObject secondObject = new JSONObject()
secondObject.put("question", "hello world?")
secondObject.put("answers", two) 
questionsArray.put(secondObject)

//do this for all your items then add the questions array to your jsonObject
JSONObject mainJsonObj = new JSONObject()
mainJsonObj.put("questions", questionsArray);

//then when you need the data you will go like this:
questionsArray = mainJsonObj.optJSONArray("questions")

//then you have your ordered array containing your question/answer objects, the answers of which will be ordered. To get them you will have to get by index like:
objOne = questionsArray.get(0) //etc
String question = objOne.optString("question")
JSONArray answers = objOne.optString("answers")