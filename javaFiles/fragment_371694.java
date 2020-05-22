//we are creating & oppening another connection to new adres as at beginning 
HttpUrlConnection connection = (HttpURLConnection) new URL(adressToUserData).openConnection();

// but we do not construct user value/kay data & don't create output stream 
// we just add obtained cookies as request property 
connection.addRequestProperty("Cookie", _cookie); 

//connecting
connection.connect();

//getting input stram 
InputStrem is = connection.getInputStream();

//parse data for example with jsoup 
Document doc = JSoup.parse(is,null"");

//show parsed result example in grid view