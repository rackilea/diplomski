Image image1 = Image.getInstance("watermark.png");
   document.add(image1);

   String imageUrl = "http://applause-voice.com/wp-content/uploads/2011/04/1hello.jpg";
   Image image2 = Image.getInstance(new URL(imageUrl));
   document.add(image2);