// obtain the Exif SubIFD directory
ExifSubIFDDirectory directory 
    = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

// query the datetime tag's value
Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);