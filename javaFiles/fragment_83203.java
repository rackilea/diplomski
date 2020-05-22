List<Element> params = testcase.getChildren("parameter");
            for(Element ele : params){
                String key = ele.getChildText("key");
                String value = ele.getChildText("value");
                parameters.put(key, value);
            }