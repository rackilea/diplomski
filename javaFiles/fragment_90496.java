byte[] imageBytes = getImageAsBytes();

response.setContentType("image/jpeg");
response.setContentLength(imageBytes.length);

response.getOutputStream().write(imageBytes);