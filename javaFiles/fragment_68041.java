String json = "{\"Name\":{" +
            "\"object1\":{" +
            "\"field1\":\"17\",\"field2\":\"360\",\"field3\":\"19\",\"field4\":\"sun\",\"field5\":\"rain\"}}}";

Gson gson = new Gson();
GsonObj jsonResult = gson.fromJson(json, GsonObj.class);
Log.d("test", "field one: "+jsonResult.name.obj.fieldOne);
Log.d("test", "field two: "+jsonResult.name.obj.fieldTwo);
Log.d("test", "field three: "+jsonResult.name.obj.fieldThree);
Log.d("test", "field four: "+jsonResult.name.obj.fieldFour);