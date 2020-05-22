protected String doInBackground(String... strings) {
        String result = "";
        URL url;
        HttpsURLConnection urlConnection = null;
        HttpURLConnection xurlConnection = null; //ADDED for stage 2 testing

        /* <<<<<<<<<<< COMMENT OUT DATA RETRIEVAL >>>>>>>>>>
        try {
            url = new URL (strings[0]);
            urlConnection = (HttpsURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while (data != -1){
                char current = (char) data;
                result += current;
                data = reader.read();
            }
            //Log.i("URLContent",result);

            JSONArray jsonArray = new JSONArray(result);
            int numberOfItems = 20;
            if(jsonArray.length() <20){
                numberOfItems = jsonArray.length();
            }
            //to clear the table before add data
            articleDB.execSQL("DELETE FROM articles"); //will clear everything and add a new data
            for (int i=0;i<numberOfItems;i++ ){
                //Log.i("JSONItem",jsonArray.getString(i));
                String articleId = jsonArray.getString(i);
                url = new URL("https://hacker-news.firebaseio.com/v0/item/"+articleId+".json?print=pretty");
                urlConnection = (HttpsURLConnection) url.openConnection();
                in = urlConnection.getInputStream();
                reader = new InputStreamReader(in);
                data = reader.read();
                String articleInfo = "";
                while (data!= -1){
                    char current = (char) data;
                    articleInfo += current;
                    data = reader.read();
                }
                //Log.i("ArticleInfo",articleInfo);
                //separate title and URL
                JSONObject jsonObject = new JSONObject(articleInfo);
                if (!jsonObject.isNull("title") && !jsonObject.isNull("url")){
                    String articleTitle = jsonObject.getString("title");
                    String articleURL = jsonObject.getString("url");
                    //Log.i("info",articleTitle + articleURL);
                    url = new URL(articleURL);
                    xurlConnection =  (HttpURLConnection) url.openConnection();
                    in = xurlConnection.getInputStream();
                    reader = new InputStreamReader(in);
                    data = reader.read();
                    String articleContent = "";
                    while (data!= -1){
                        char current = (char) data;
                        articleContent += current;
                        data = reader.read();
                    }
                    //Log.i("articleContent",articleContent);

                    String sql = "INSERT INTO articles(articleID,title,content) VALUES(? , ? , ?)";
                    SQLiteStatement statement = articleDB.compileStatement(sql);
                    statement.bindString(1,articleId);
                    statement.bindString(2,articleTitle);
                    statement.bindString(3,articleContent);
                    statement.execute();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        <<<<<<<<<< END OF COMMENTED OUT CODE >>>>>>>>>> */
        ContentValues cv = new ContentValues();
        cv.put("articleID",1);
        cv.put("title","Title");
        cv.put("content","Some content");
        articleDB.insert("articles",null,cv);
        return null;
    }