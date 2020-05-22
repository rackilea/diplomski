String title = localBufferReader.readLine();
String content_path = localBufferReader1.readLine();

// Get the resource ID
int contentResourceId = getResources().getIdentifier("raw/" + content_path, null, this.getPackage());

// Open the resource as a buffered reader
BufferedReader contentBufferReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(contentResourceId)));

// Parse the contents as an int
int content = Integer.parseInt(contentBufferReader.readLine());