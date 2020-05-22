gc.save();
gc.setTransform(new Affine(new Rotate(angle, image1CenterX, image1CenterY)));
gc.drawImage(image1, image1X, image1Y);
gc.restore();

gc.save();
gc.setTransform(new Affine(new Rotate(angle, image2CenterX, image2CenterY)));
gc.drawImage(image2, image2X, image2Y);
gc.restore();

...