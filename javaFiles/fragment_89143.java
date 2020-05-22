for( SearchHit hit : response.getHits())
            {
                Map<String, Object> map = hit.getSource();
             String s0 = map.get("first_name").toString();
             result.add(s0);
             String s1 = map.get("last_name").toString();
             result.add(s1);
             String s2 ="";
             if(map.containsKey("middle_name"))
            {
             String s2 = map.get("middle_name").toString();
             result.add(s2);
            }

            finalresult = s0 + "|" + s1 + "|" + s2;
            }