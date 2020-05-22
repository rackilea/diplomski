String fullUrl = "http://見.香港/images/wonton.jpg";
URL url = new URL(fullUrl);

url.getProtocol(); // "http"
url.getHost(); // "見.香港"
url.getPath(); // "/images/wonton.jpg"

String asciiHost = IDN.toASCII(url.getHost());
String validUrl = url.getProtocol() + "://" + asciiHost + url.getPath();
System.out.println(validUrl);
BufferedImage bi = ImageIO.read(new URL(validUrl));