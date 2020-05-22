FileInputStream fis = new FileInputStream( "yourFile.txt" );
BufferedInputStream bis = new BufferedInputStream( fis );
byte [] buffer = new byte [ 8 ];
int bytesRead = 0;
String chunk = "";

while ( ( bytesRead = bis.read( buffer ) ) != -1 )
    chunk = new String( buffer, 0, bytesRead );