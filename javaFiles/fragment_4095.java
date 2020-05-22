gc.save();
gc.setTransform((new Affine(new Rotate(angle, rotationCenterX, rotationCenterY)));

gc.drawImage(image1, image1unrotatedX, image1unrotatedY);
gc.drawImage(image2, image2unrotatedX, image2unrotatedY);
...

gc.restore();