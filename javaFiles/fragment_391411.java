String address = "image_url";
URL url = new URL(address);
URLConnection urlC = url.openConnection();
urlC.connect();
InputStream is = urlC.getInputStream();
for(int i = 0; i < 92; i++) is.read();

nt byte1 = is.read();
int byte2 = is.read();

int width = (byte1 << 8) + byte2;

for(int i = 0; i < 10; i++) is.read();

byte1 = is.read();
byte2 = is.read();

int height = (byte1 << 8) + byte2;

System.out.println("width = " + width + " | height = " + height);

is.close();