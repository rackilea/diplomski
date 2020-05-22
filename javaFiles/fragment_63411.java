Connection.Response response = Jsoup.connect(url).timeout(60 * 1000)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) "
                    + "Chrome/33.0.1750.152 Safari/537.36").ignoreContentType(true)
                    .execute();

byte[] bytes = response.bodyAsBytes();

//this is how you write the file
try (FileOutputStream outputStream = new FileOutputStream(<somefilehere>)) {
        outputStream.write(bytes);
} catch (Exception e) {  }