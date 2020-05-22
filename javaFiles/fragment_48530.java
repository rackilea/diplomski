String result = "Your JsonArray Data Like [{}]";

            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray jsonarray = new JSONArray(result);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String story = null;
                    try {
                        story = jsonobject.getString("story");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String msg = null;
                    try {
                        msg = jsonobject.getString("message");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String ct = jsonobject.getString("created_time");
                    String id = jsonobject.getString("id");

                    if (msg == null){
                        msg = "";
                    }
                    if (story == null){
                        story = "";
                    }
                    arrayList.add(story + msg + ct + id);
      //            Smodel is getter model
      //            arrayList.add(new Smodel(story, msg, ct, id));
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }