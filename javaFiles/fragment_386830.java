URL iotd;
try {
    iotd = new URL("http://www.nasa.gov/rss/image_of_the_day.rss");
} catch (MalformedURLException e) {
    e.printStackTrace();
    return;
}