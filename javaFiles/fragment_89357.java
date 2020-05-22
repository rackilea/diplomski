ArrayList<HashMap<String, String>> bookList = new ArrayList<HashMap<String, String>>();
for(int i = 0; i<result.length(); i++) {
        JSONObject bookData = result.getJSONObject(i);
        bookid = bookData.getString(Config.KEY_id);
        booktitle = bookData.getString(Config.KEY_title);
        author = bookData.getString(Config.KEY_author);
        isbn = bookData.getString(Config.KEY_isbn);
        publishers = bookData.getString(Config.KEY_publisher);
        publishedyear = bookData.getString(Config.KEY_publishedyear);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", "Book Id : " + bookid);
        map.put("title", "Title : " + booktitle);
        map.put("author", "Author : " + author);
        bookList.add(map);
         System.out.println(bookList);

    }

SimpleAdapter simpleAdapter = new  SimpleAdapter(this,bookList, R.layout.customiselistview, new String[]{"id", "title", "author"}, new int[]{R.id.textViewid, R.id.textViewtitle, R.id.textViewauthor});
searchresultview.setAdapter(simpleAdapter);