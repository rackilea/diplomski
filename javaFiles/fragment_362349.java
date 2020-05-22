String urlString = "https://www.youtube.com/audiolibrary_download?vid=d0a68933f592c297";
        URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        int statusCode = huc.getResponseCode(); //get response code
        if (statusCode == HttpURLConnection.HTTP_MOVED_TEMP
                || statusCode == HttpURLConnection.HTTP_MOVED_PERM){ // if file is moved, then pick new URL
            urlString = huc.getHeaderField("Location");
            url = new URL(urlString);
            huc = (HttpURLConnection)url.openConnection();
        }
        System.out.println(urlString);  
        InputStream is = huc.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        FileOutputStream fos = new FileOutputStream("test.mp3");
        int i = 0;
        while ((i = bis.read()) != -1)
            fos.write(i);