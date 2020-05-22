// in your HTML :
<img src="/getImage.action?imageId=${id_of_the_image}"/>

// in the servlet mapped to /getImage.action:
// get the ID of the image from the request parameters
String imageId = request.getParameter("imageId");
byte[] imageData = getImageFromDatabase(imageId);
response.setContentType("image/jpeg");
response.getOutputStream().write(imageData);