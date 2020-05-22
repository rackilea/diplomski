ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(img, "png", baos);

byte[] bytes = baos.toByteArray()
activeUserShop.setImage(bytes);
System.out.println("Image uploaded! Lenght: "+bytes+"bytes");
EntityTransaction tx = em.getTransaction();
System.out.println(activeUserShop.toString());
tx.begin();
manager.updateUser(activeUserShop);
tx.commit();