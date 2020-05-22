for (int j = 0; j < counter_blog; j++) { 
if (s != null) {
s = dis.readLine();
s.substring(s.indexOf("<p>") + 3, s.indexOf("</p>"));

if(s.contains("<p><a href=")) {
image[j] = s.substring(s.indexOf("<a href=") + 9, s.indexOf(".jpg") + 4);
Log.e("TattlerMX Found url", "Found url:" + image[j]);
blog[j] = image[j];
**img_detected[j] = 1;**
} else {
blog[j] = s; 
**img_detected[j] = 0;**
Log.e("TattlerMX Found blog", "Found blog:" + blog[j]);
        }
    }
    counter_blog_stop = j + 1;      
}