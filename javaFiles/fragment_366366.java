StringBuffer buffer = new StringBuffer();
while ((inputLine = in.readLine()) != null)
{
    buffer.append(inputLine).append('\n');
    cicliLettura++;
}
String result = buffer.toString();