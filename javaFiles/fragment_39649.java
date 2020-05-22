Document doc = Jsoup.connect("url").get();
Element image = doc.select("img[class=lr-logo-img lr-standings-logo-img").first();

String src = image.attr("src"); 
String key = ";base64,";    
int index = src.indexOf(key);
String base64 = src.substring(index+key.length());

byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);       
Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);     
imageView.setImageBitmap(decodedByte);