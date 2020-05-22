public void loadLocalHtmlToWebView() throws IOException {

        WebView mWebView = findViewById(R.id.my_webview);

        File publicDir = new File(getCacheDir(), "public");

        if (publicDir.exists() == false) {

            publicDir.mkdirs();

            String[] ls = getAssets().list("public");


            for (int i = 0; i < ls.length; i++) {

                InputStream inputStream = getAssets().open("public/" + ls[i]);

                File outFileLocation = new File(publicDir, ls[i]);

                outFileLocation.createNewFile();

                Log.e("AMIR", "Wrinting to : " + outFileLocation.getPath());

                FileOutputStream fileOutputStream = new FileOutputStream(outFileLocation);

                byte[] buffer = new byte[1024];

                while (inputStream.read(buffer) != -1) {

                    fileOutputStream.write(buffer);

                }

                fileOutputStream.flush();
                fileOutputStream.close();

                inputStream.close();


            }

        }


        String indexHtml="";

        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(publicDir,"index.html")));

        String ln="";

        while((ln=bufferedReader.readLine())!=null){

            indexHtml+=ln;

        }

        bufferedReader.close();

        Log.e("AMIR","Html : "+indexHtml);


        String baseUrl = "file://" + publicDir.getPath() + "/";

        mWebView.loadDataWithBaseURL(baseUrl, indexHtml, "text/html", "UTF-8", null);

    }