File image = // path to some image
ExifTool tool = new ExifTool();

Map<Tag, String> valueMap =
    tool.getImageMeta(image, Tag.GPS_LATITUDE, Tag.GPS_LONGITUDE);

System.out.println("Lat: " + valueMap.get(Tag.GPS_LATITUDE) +
    "\tLong: " + valueMap.get(Tag.GPS_LONGITUDE));