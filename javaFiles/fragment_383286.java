URL url = new URL(URL_TO_APPLICATION);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
InputStream stream = connection.getInputStream();
Scanner scanner = new Scanner(stream); // You can read the stream however you want. Scanner was just an easy example
boolean found = false;
while(scanner.hasNext()) {
    String next = scanner.next();
    if(TOKEN.equals(next)) {
        found = true;
        break;
    }
}

if(found) {
    doSomethingAwesome();
} else {
    throw aFit();
}