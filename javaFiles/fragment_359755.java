try {
            result  = result.replace("Array","");
            JSONArray jArray = new JSONArray(result);
            JSONObject json = jArray.getJSONObject(0);
            String username = json.getString("username");

        } catch (Exception e) {
            error2 = e.getMessage().toString();
            // TODO: handle exception
            Log.e("log_tag", "Error Parsing Data "+e.toString());
        }
        dialog.dismiss();