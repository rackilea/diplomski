if (Integer.parseInt(res) == 1) {
                publishProgress(1);
                // user successfully registred
                // Store user details in SQLite Database
                DatabaseHandler db = new DatabaseHandler(
                        getApplicationContext());
                JSONObject json_user = json.getJSONObject("user");