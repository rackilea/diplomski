final BufferedReader rd = new BufferedReader(new 
InputStreamReader(is));
stringBuffer = new StringBuffer();
while ((line = rd.readLine()) != null) {
   stringBuffer.append(line);
}
rd.close();