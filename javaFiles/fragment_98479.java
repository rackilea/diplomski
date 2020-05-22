if (!jsonObject.isNull("title") && !jsonObject.isNull("url")){
                    String articleTitle = jsonObject.getString("title");
                    String articleURL = jsonObject.getString("url");
                    //Log.i("info",articleTitle + articleURL);
                    url = new URL(articleURL);
                    //urlConnection =  (HttpsURLConnection) url.openConnection(); //<<<<<<<<<< commented out
                    xurlConnection = (HttpURLConnection) url.openConnection(); //<<<<<<<<<< added to replace commented out line. 
                    in = urlConnection.getInputStream();
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