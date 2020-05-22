public static void rotateImage(Graphics g, Image image,int tilt,JComponent component)
    {

        // create the transform, note that the transformations happen

                  // in reversed order (so check them backwards)
                  AffineTransform at = new AffineTransform();

                  //5. modify component scale ...

                  double sin = Math.abs(Math.sin(Math.toRadians(tilt)));
                  double cos = Math.abs(Math.cos(Math.toRadians(tilt)));

                  int w=image.getWidth(null);
                  int h=image.getHeight(null);
                  int newW=(int) Math.floor(w * cos + h * sin);
                  int newH=(int) Math.floor(h * cos + w * sin);

                  component.setSize(newW, newH);

                  int width=component.getWidth();
                  int height=component.getHeight();

                  // 4. translate it to the center of the component
                  at.translate(width / 2, height / 2);

                  // 3. do the actual rotation
                  at.rotate(Math.toRadians(tilt));

                  // 2. just a scale because this image is big
    //              at.scale(1, 1);


                  // 1. translate the object so that you rotate it around the
                  //    center (easier :))
                  at.translate(-image.getWidth(null)/2, -image.getHeight(null)/2);



                  // draw the image
                  ((Graphics2D) g).drawImage(image, at, null);


        }