System.out.println(jsonObject2.get("tr_name"));

                System.out.println(((JSONObject) ((JSONObject) jsonObject2.get("attrs")).get(".attributes"))
                        .get("tr_description"));
                System.out.println(
                        ((JSONObject) ((JSONObject) jsonObject2.get("attrs")).get(".attributes")).get("tr_rules"));

                System.out.println(((JSONObject) jsonObject2.get("source")).get("id"));
                System.out.println(((JSONObject) jsonObject2.get("target")).get("id"));