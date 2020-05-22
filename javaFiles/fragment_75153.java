try{
                String encodedUrl = URLEncoder.encode("name with spaces", "UTF-8");
                URL url = new URL("https://site.com/android/dir/file.php?paramName="+encodedUrl);
                URLConnection urlConnection = url.openConnection();
                @SuppressWarnings("unused")
                InputStream in = urlConnection.getInputStream();
                }catch(Exception e){
                    e.printStackTrace();
                }
    }