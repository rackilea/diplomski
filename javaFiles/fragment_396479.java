try {
        JSONObject jsonObject = new JSONObject("{" +
                "\"Response\": [" +
                "    {" +
                "        \"TicketID\": \"200\"," +
                "        \"update\": [" +
                "            {" +
                "                \"Type\": \"Group\"," +
                "                \"user\": \"ABC\"," +
                "                \"groupName\": \"RTT\"," +
                "                \"updatetime\": \"1465367505863\"" +
                "            }," +
                "            {" +
                "                \"Type\": \"status\"," +
                "                \"user\": \"ABC\"," +
                "                \"status\": \"Open\"," +
                "                \"updatetime\": \"1465367505858\"" +
                "            }," +
                "            {" +
                "                \"Type\": \"comment\"," +
                "                \"user\": \"ABC\"," +
                "                \"comments\": \"Updating \"," +
                "                \"updatetime\": \"1465367505854\"" +
                "            }" +
                "        ]" +
                "    }," +
                "    {" +
                "        \"TicketID\": \"300\"," +
                "        \"update\": [" +
                "            {" +
                "                \"Type\": \"Group\"," +
                "                \"user\": \"ABC\"," +
                "                \"groupName\": \"RTT\"," +
                "                \"updatetime\": \"1465367505863\"" +
                "            }," +
                "            {" +
                "                \"Type\": \"status\"," +
                "                \"user\": \"ABC\"," +
                "                \"status\": \"Open\"," +
                "                \"updatetime\": \"1465367505854\"" +
                "            }," +
                "            {" +
                "                \"Type\": \"comment\"," +
                "                \"user\": \"ABC\"," +
                "                \"comments\": \"Updating Group\"," +
                "                \"updatetime\": \"1465367505834\"" +
                "            }" +
                "        ]" +
                "    }" +
                "]" +
                "}");

        JSONArray jsonArray = jsonObject.optJSONArray("Response");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject object = jsonArray.getJSONObject(i);

            String TicketID = object.optString("TicketID");

            System.out.println("TicketID ----"+TicketID);

            JSONArray update = object.getJSONArray("update");

            for (int j = 0; j < update.length(); j++) {

                JSONObject obj = update.getJSONObject(j);

                String Type = obj.optString("Type");
                System.out.println("Type :"+i+":"+Type);
                String user = obj.optString("user");
                System.out.println("user :"+i+":"+user);
                String groupName = obj.optString("groupName");
                System.out.println("groupName :"+i+":"+groupName);
                String updatetime = obj.optString("updattime");
                System.out.println("updatetime :"+i+":"+updatetime);
            }

        }

    } catch (JSONException e) {
        e.printStackTrace();
    }