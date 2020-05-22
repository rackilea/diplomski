String[] image = new String[] {"APP","FIELD","KYC"};
String[] image2 = new String[] {"MEMORANDUM","ASSOCIATION"};
String[] result = new String[image.length + image2.length]; 

// copies an array from the specified source array
System.arraycopy(image, 0, result, 0, image.length);
System.arraycopy(image2, 0, result, image.length, image2.length);

// Now you can use result for final array