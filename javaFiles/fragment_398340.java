MultipartFile file = productForm.getAttachment();  
...
byte[] result = new byte[(int) file.getSize()]; // Bug: Empty array
Image img = new Image();
img.setContent(result);
ByteArrayInputStream in = new ByteArrayInputStream(img.getContent());