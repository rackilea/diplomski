MultipartFile file = productForm.getAttachment();  
...
byte[] result = file.getBytes(); // Good: The content of the uploaded file
Image img = new Image();
img.setContent(result);
ByteArrayInputStream in = new ByteArrayInputStream(img.getContent());