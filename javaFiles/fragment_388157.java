while ((inputLine = in.readLine()) != null) {

                JSONParser jsonParser = new JSONParser();
                JSONArray jsonArray = (JSONArray) jsonParser.parse(inputLine);
                for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject object = (JSONObject) jsonArray.get(i);  
                String date = new java.sql.Timestamp(System.currentTimeMillis()).toString();
                out.write(date.getBytes());
                out.write(",".getBytes());
                out.writeBytes((String) object.get("name"));
                out.write(",".getBytes());
                out.writeBytes((String) object.get("label"));
                out.write(",".getBytes());
                out.writeBytes(String.valueOf(object.get("value")));
                //out.write(inputLine.getBytes());
                out.write("\n".getBytes());
                out.hflush();

            }