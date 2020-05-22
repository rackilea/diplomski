URL downloadURL = new URL(versionCode[1]);
HttpURLConnection urlConnection = (HttpURLConnection) downloadURL.openConnection();
urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
InputStream inputStream = urlConnection.getInputStream();
Files.copy(inputStream, outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
inputStream.close();