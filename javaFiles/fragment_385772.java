//Open a URL Stream
Response resultImageResponse = Jsoup.connect(imageLocation).cookies(cookies)
                                        .ignoreContentType(true).execute();

// output here
FileOutputStream out = (new FileOutputStream(new java.io.File(outputFolder + name)));
out.write(resultImageResponse.bodyAsBytes());  // resultImageResponse.body() is where the image's contents are.
out.close();