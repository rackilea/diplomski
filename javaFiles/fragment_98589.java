StringBuilder sb = new StringBuilder()
while ((inputLine = clientSocketInputStream.readLine()) != null)
{
    String message = inputLine;
    sb.append(message);
    sb.append('\n');
}
String message = sb.toString();